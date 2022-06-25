package com.board.board;

import oracle.jdbc.proxy.annotation.Pre;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class FileDAO {
    @Autowired
    private BasicDataSource basicDataSource;

    public int insert(int seq_board, String file) throws Exception {
        String sql = "insert into tbl_file values(seq_file.nextval, ? , ?)";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, seq_board);
            preparedStatement.setString(2, file);

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<FileDTO> getFileList(int board_seq) throws Exception{
        String sql = "select * from tbl_file where seq_board = ? ";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, board_seq);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<FileDTO> arrayList = new ArrayList<>();

            while(resultSet.next()){
                int seq_file = resultSet.getInt(1);
                int seq_board = resultSet.getInt(2);
                String file_name = resultSet.getString(3);

                arrayList.add(new FileDTO(seq_file,seq_board,file_name));
            } return arrayList;
        }
    }

    public int delete(String file_name) throws Exception {
        String sql = "delete from tbl_file where FILE_NAME=?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, file_name);

            return preparedStatement.executeUpdate();
        }
    }
}
