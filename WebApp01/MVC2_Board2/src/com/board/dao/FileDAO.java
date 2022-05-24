package com.board.dao;

import com.board.dto.FileDTO;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.PipedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

    public int insert(FileDTO fileDTO) throws Exception{
        String sql = "insert into tbl_file values(seq_file.nextval, seq_board.curval, ?,?)";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, fileDTO.getFileOriName());
            preparedStatement.setString(2, fileDTO.getFileSysName());

            return preparedStatement.executeUpdate();
        }
    }
}
