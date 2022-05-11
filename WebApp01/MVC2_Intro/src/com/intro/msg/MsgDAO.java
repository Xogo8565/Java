package com.intro.msg;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MsgDAO {
    private BasicDataSource basicDataSource;

    private MsgDAO() {
        try {
            Context context = new InitialContext();
            Context contextEnv = (Context) context.lookup("java:comp/env");
            basicDataSource = (BasicDataSource) contextEnv.lookup("jdbc/bds");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class InstanceHolder {
        private static final MsgDAO instance = new MsgDAO();
    }

    public static MsgDAO getInstance() {
        return InstanceHolder.instance;
    }

    public Connection getConnection() throws SQLException {
        return basicDataSource.getConnection();
    }

    public int insert(MsgDTO msgDTO) throws Exception {
        String sql = "insert into tbl_msg values(seq_msg.nextval, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, msgDTO.getNickname());
            preparedStatement.setString(2, msgDTO.getMsg());

            return preparedStatement.executeUpdate();

        }
    }

    public ArrayList<MsgDTO> selectAll() throws Exception {
        String sql = "select * from tbl_msg";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<MsgDTO> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int no = resultSet.getInt(1);
                String nickname = resultSet.getString(2);
                String msg = resultSet.getString(3);
                arrayList.add(new MsgDTO(no, nickname, msg));
            }
            return arrayList;
        }
    }
}
