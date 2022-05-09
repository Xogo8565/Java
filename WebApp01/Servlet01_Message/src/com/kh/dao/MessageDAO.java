package com.kh.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MessageDAO {
    BasicDataSource basicDataSource = new BasicDataSource();

    public MessageDAO(){
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setDriverClassName("jdbc.oracle.driver.OracleDriver");
        basicDataSource.setUsername("kh");
        basicDataSource.setPassword("kh");
        basicDataSource.setInitialSize(30);
    }

    public Connection getConnection() throws Exception{
        return basicDataSource.getConnection();
    }

    // insert nickname , message
    public int insertMessage(String nickname, String message) throws Exception{
        String sql = "insert into tbl_msg values(?,?)";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,nickname);
            preparedStatement.setString(2,message);

            return preparedStatement.executeUpdate();
        }
    }
}
