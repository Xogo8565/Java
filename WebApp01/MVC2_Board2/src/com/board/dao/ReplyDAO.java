package com.board.dao;

import com.board.dto.BoardDTO;
import com.board.dto.ReplyDTO;
import com.board.utils.DateToString;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReplyDAO {
    private BasicDataSource basicDataSource;

    public ReplyDAO() {
        try {
            Context context = new InitialContext();
            Context envContext = (Context) context.lookup("java:comp/env");
            basicDataSource = (BasicDataSource) envContext.lookup("jdbc/bds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    public ArrayList<ReplyDTO> selectAllReply(int no) throws Exception {
        String sql = "select * from tbl_reply where board_no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, no);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<ReplyDTO> arrayList = new ArrayList<ReplyDTO>();
            while (resultSet.next()) {
                int reply_no = resultSet.getInt(1);
                int board_no = resultSet.getInt(2);
                String content = resultSet.getString(3);
                String id = resultSet.getString(4);
                String nickname = resultSet.getString(5);
                String written_date = DateToString.dateToString(resultSet.getDate(6));
                arrayList.add(new ReplyDTO(reply_no, board_no, content, id, nickname, written_date));
            }  return arrayList;
        }
    }

    public int insert(ReplyDTO replyDTO) throws Exception {
        String sql = "insert into tbl_reply values(seq_reply.nextval,?,?,?,?,sysdate)";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, replyDTO.getBoard_no());
            preparedStatement.setString(2,replyDTO.getContent());
            preparedStatement.setString(3,replyDTO.getId());
            preparedStatement.setString(4, replyDTO.getNickname());

            return preparedStatement.executeUpdate();
        }
    }

    public int delete(int no) throws Exception{
        String sql = "delete from tbl_reply where reply_no = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, no);

            return preparedStatement.executeUpdate();
        }
    }

    public int update (String reply, int reply_no) throws Exception {
        String sql = "update tbl_reply set content = ? where reply_no = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, reply);
            preparedStatement.setInt(2, reply_no);

            return preparedStatement.executeUpdate();
        }
    }
}
