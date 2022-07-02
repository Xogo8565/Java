package com.board.dao;

import com.board.dto.FileDTO;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileDAO {
    private BasicDataSource basicDataSource;

    public FileDAO() {
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

    public int insert(FileDTO fileDTO) throws Exception {
        String sql = "insert into tbl_file values(seq_file.nextval, ?, ? ,?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, fileDTO.getBoard_seq());
            preparedStatement.setString(2, fileDTO.getFileOriName());
            preparedStatement.setString(3, fileDTO.getFileSysName());

            return preparedStatement.executeUpdate();
        }
    }
    public FileDTO selectAll(int board_seq) throws Exception {
        String sql = "select * from tbl_file where board_seq=?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setInt(1, board_seq);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int file_seq = resultSet.getInt(1);
                String fileOriName = resultSet.getString(3);
                String fileSysName = resultSet.getString(3);

                return new FileDTO(file_seq, board_seq, fileOriName, fileSysName);
            } return null;
        }
    }

    public FileDTO selectByFile_seq(int file_seq) throws Exception {
        String sql = "select * from tbl_file where file_seq=?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setInt(1, file_seq);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int board_seq = resultSet.getInt(1);
                String fileOriName = resultSet.getString(3);
                String fileSysName = resultSet.getString(3);

                return new FileDTO(board_seq, file_seq, fileOriName, fileSysName);
            } return null;
        }
    }
}
