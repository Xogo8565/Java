package com.board.dao;

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
}
