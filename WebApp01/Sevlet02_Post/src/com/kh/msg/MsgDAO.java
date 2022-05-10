package com.kh.msg;

import oracle.jdbc.proxy.annotation.Pre;
import org.apache.commons.dbcp2.BasicDataSource;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public int insert(MsgDTO msgDTO) throws Exception {
        String sql = "insert into tbl_post values(?,?)";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, msgDTO.getId());
            preparedStatement.setString(2, msgDTO.getMsg());

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<MsgDTO> selectAll() throws Exception {
        String sql = "select * from tbl_post";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<MsgDTO> arrayList = new ArrayList<>();

            while(resultSet.next()){
                String id = resultSet.getString(1);
                String msg = resultSet.getString(2);

                arrayList.add(new MsgDTO(id,msg));
            }

            return arrayList;
        }
    }

    public int delete(String id) throws  Exception {
        String sql = "delete from tbl_post where id = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, id);

            return preparedStatement.executeUpdate();
        }
    }

    public int update(MsgDTO msgDTO) throws Exception{
        String sql = "update tbl_msg set msg = ? where id = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, msgDTO.getMsg());
            preparedStatement.setString(2, msgDTO.getId());

            return preparedStatement.executeUpdate();
        }
    }
}
