package com.kh.post;


import oracle.jdbc.proxy.annotation.Pre;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PostDAO {
    private BasicDataSource basicDataSource;

    public PostDAO() {
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

    public int insert(PostDTO postDTO) throws Exception {
        String sql = "insert into tbl_post values(seq_post.nextval, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, postDTO.getId());
            preparedStatement.setString(2, postDTO.getMsg());

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<PostDTO> selectAll() throws Exception {
        String sql = "select * from tbl_post";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            ArrayList<PostDTO> arrayList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int no = resultSet.getInt(1);
                String id = resultSet.getString(2);
                String msg = resultSet.getString(3);
                arrayList.add(new PostDTO(no, id, msg));
            }
            return arrayList;
        }
    }

    public int delete(int no) throws Exception {
        String sql = "delete from tbl_post where no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, no);

            return preparedStatement.executeUpdate();
        }
    }

    public PostDTO selectByNo(int no) throws Exception {
        String sql = "select * from tbl_post where no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, no);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new PostDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            } else  return null;
        }
    }

    public int modify(PostDTO postDTO) throws Exception{
        String sql = "update tbl_post set id = ?, msg = ? where no = ?";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, postDTO.getId());
            preparedStatement.setString(2, postDTO.getMsg());
            preparedStatement.setInt(3, postDTO.getNo());

            return preparedStatement.executeUpdate();
        }
    }
}