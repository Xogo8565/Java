package com.board.dao;

import com.board.dto.BoardDTO;
import com.board.utils.DateToString;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
    private BasicDataSource basicDataSource;

    public BoardDAO() {
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

    public int newPost(BoardDTO boardDTO) throws Exception {
        String sql = "insert into tbl_board values(seq_board.nextval,?,?,?,?,0,sysdate)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, boardDTO.getId());
            preparedStatement.setString(2, boardDTO.getNickname());
            preparedStatement.setString(3, boardDTO.getTitle());
            preparedStatement.setString(4, boardDTO.getContent());

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<BoardDTO> selectAll() throws Exception {
        String sql = "select * from tbl_board order by 1 desc";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BoardDTO> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int no = resultSet.getInt(1);
                String id = resultSet.getString(2);
                String nickname = resultSet.getString(3);
                String title = resultSet.getString(4);
                String content = resultSet.getString(5);
                int view_count = resultSet.getInt(6);
                String written_date = DateToString.dateToString(resultSet.getDate(7));

                arrayList.add(new BoardDTO(no, id, nickname, title, content, view_count, written_date));
            }

            return arrayList;
        }
    }

    public BoardDTO selectByNo(int no) throws Exception {
        String sql = "select * from tbl_board where no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, no);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString(2);
                String nickname = resultSet.getString(3);
                String title = resultSet.getString(4);
                String content = resultSet.getString(5);
                int view_count = resultSet.getInt(6);
                String written_date = DateToString.dateToString(resultSet.getDate(7));

                return new BoardDTO(no, id, nickname, title, content, view_count, written_date);
            }
            return null;
        }
    }

}
