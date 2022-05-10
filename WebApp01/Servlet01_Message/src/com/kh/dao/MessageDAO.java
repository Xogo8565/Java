package com.kh.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MessageDAO {
    BasicDataSource basicDataSource = new BasicDataSource();

    public MessageDAO() {
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("kh");
        basicDataSource.setPassword("kh");
        basicDataSource.setInitialSize(30);
    }

    public Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    // insert nickname , message
    public int insertMessage(String nickname, String message) throws Exception {
        String sql = "insert into tbl_msg values(?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nickname);
            preparedStatement.setString(2, message);

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<MessageDTO> selectAllMessage() throws Exception {
        String sql = "select * from tbl_msg";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<MessageDTO> arrayList = new ArrayList<>();

            while (resultSet.next()){
                String nickname = resultSet.getString(1);
                String msg = resultSet.getString(2);
                arrayList.add(new MessageDTO(nickname,msg));
            }

            return arrayList;
        }
    }

    public int deleteMessage (String nickname) throws Exception {
        String sql = "delete from tbl_msg where nickname = ?";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, nickname);
            return preparedStatement.executeUpdate();
        }
    }

    public int updateMessage (String nickname, String msg) throws Exception{
        String sql = "update tbl_msg set msg = ? where nickname = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);){

            preparedStatement.setString(1,msg);
            preparedStatement.setString(2,nickname);

            return preparedStatement.executeUpdate();
        }
    }
}
