package com.board.member;

import oracle.jdbc.proxy.annotation.Pre;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class MemberDAO {

    @Autowired
    private BasicDataSource basicDataSource;

    public int insert(MemberDTO memberDTO) throws Exception {
        String sql = "insert into member values(?,?,?,null,?)";
        try (Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, memberDTO.getId());
            preparedStatement.setString(2, memberDTO.getPw());
            preparedStatement.setString(3, memberDTO.getNickname());
            preparedStatement.setString(4, memberDTO.getProfile_image());

            return preparedStatement.executeUpdate();
        }
    }

    public int checkID(String id) throws Exception {
        String sql = "select count(*) from member where id = ?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            return resultSet.getInt(1);
        }
    }

    public int checkLogin(String id, String pw) throws Exception {
        String sql = "select count(*) from member where id =? and pw =?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pw);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return resultSet.getInt(1);
        }
    }

    public MemberDTO getDTO(String id, String pw) throws Exception{
        String sql = "select * from member where id =? and pw =?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pw);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                id = resultSet.getString(1);
                pw = resultSet.getString(2);
                String nickname = resultSet.getString(3);
                String profile_msg = resultSet.getString(4);
                String profile_img = resultSet.getString(5);

                return new MemberDTO(id, pw, nickname, profile_msg, profile_img);
            } return null;
        }
    }

    public int modifyProfile(MemberDTO memberDTO) throws Exception {
        String sql = "update member set profile_message = ?, profile_image = ? where id =?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, memberDTO.getProfile_message());
            preparedStatement.setString(2, memberDTO.getProfile_image());
            preparedStatement.setString(3, memberDTO.getId());

            return preparedStatement.executeUpdate();
        }
    }

    public int modifyInfo(String id, String pw, String nickname) throws Exception {
        String sql = "update member set pw =?, nickname =? where id =?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, pw);
            preparedStatement.setString(2, nickname);
            preparedStatement.setString(3, id);

            return preparedStatement.executeUpdate();
        }
    }

}
