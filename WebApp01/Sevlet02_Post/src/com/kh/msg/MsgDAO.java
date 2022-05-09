package com.kh.msg;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MsgDAO {
    private BasicDataSource basicDataSource = new BasicDataSource();
    private MsgDAO(){
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("kh");
        basicDataSource.setPassword("kh");
        basicDataSource.setInitialSize(10);
    }

    private static class InstanceHolder {
        private static final MsgDAO instance = new MsgDAO();
    }

    public static MsgDAO getInstance(){
        return InstanceHolder.instance;
    }

    public Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    public int insert(String id, String msg) throws Exception {
        String sql = "insert into tbl_msg values(?,?)";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, msg);

            return preparedStatement.executeUpdate();
        }
    }


}
