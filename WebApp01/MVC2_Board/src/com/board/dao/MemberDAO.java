package com.board.dao;

import com.board.dto.MemberDTO;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    private BasicDataSource basicDataSource;
    public MemberDAO() {
        try{
            Context context = new InitialContext();
            Context envContext = (Context) context.lookup("java:comp/env");
            basicDataSource = (BasicDataSource) envContext.lookup("jdbc/bds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    public boolean checkId (String id) throws Exception {
        String sql = "select count(*) from tbl_member where id = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            if(resultSet.getInt(1)==1) return false; // 중복이면 false
            else return true;

        }
    }

    public int signUp(MemberDTO memberDTO) throws Exception {
        String sql = "insert into tbl_member values(?,?,?,?,?,?,?,?)";

        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,memberDTO.getId());
            preparedStatement.setString(2,memberDTO.getPw());
            preparedStatement.setString(3,memberDTO.getNickname());
            preparedStatement.setString(4,memberDTO.getPhone());
            preparedStatement.setString(5,memberDTO.getPostcode());
            preparedStatement.setString(6,memberDTO.getAddress_1());
            preparedStatement.setString(7,memberDTO.getAddress_2());
            preparedStatement.setString(8,memberDTO.getAddress_3());

            return preparedStatement.executeUpdate();
        }
    }

    public boolean checkLogin(String id, String pw) throws Exception {
        String sql = "SELECT count(*) FROM tbl_member WHERE id = ?  and pw = ?";

        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pw);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            if(resultSet.getInt(1)==1) return true;
            else return false;
        }
    }

    public MemberDTO getLoginMemberInfo(String id) throws Exception {
        String sql = "select * from tbl_member where id =?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String pw = resultSet.getString(2);
                String nickname = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String postCode = resultSet.getString(5);
                String address_1 = resultSet.getString(6);
                String address_2 = resultSet.getString(7);
                String address_3 = resultSet.getString(8);

                return new MemberDTO(id, pw, nickname, phone, postCode, address_1, address_2, address_3);
            } else return null;
        }
    }

}
