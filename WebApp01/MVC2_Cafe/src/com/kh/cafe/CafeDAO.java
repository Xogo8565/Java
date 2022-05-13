package com.kh.cafe;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CafeDAO {
    private BasicDataSource basicDataSource;

    public CafeDAO() {
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

    public int insert(CafeDTO cafeDTO) throws Exception {
        String sql = "insert into tbl_cafe values(seq_cafe.nextval, ?,?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cafeDTO.getProduct_name());
            preparedStatement.setInt(2, cafeDTO.getProduct_price());
            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<CafeDTO> selectAll() throws Exception {
        String sql = "select * from tbl_cafe";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<CafeDTO> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                int product_id = resultSet.getInt(1);
                String product_name = resultSet.getString(2);
                int product_price = resultSet.getInt(3);
                arrayList.add(new CafeDTO(product_id, product_name, product_price));
            }

            return arrayList;
        }
    }

    public CafeDTO selectByNo(int product_no) throws Exception {
        String sql = "select * from tbl_cafe where product_no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, product_no);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new CafeDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)
                );
            } else return null;
        }
    }

    public int modify(CafeDTO cafeDTO) throws Exception {
        String sql = "update tbl_cafe set product_name = ?, product_price =? where product_no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cafeDTO.getProduct_name());
            preparedStatement.setInt(2, cafeDTO.getProduct_price());
            preparedStatement.setInt(3, cafeDTO.getProduct_no());

            return preparedStatement.executeUpdate();
        }
    }

    public int delete(int product_id) throws Exception {
        String sql = "delete from tbl_cafe where product_no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, product_id);

            return preparedStatement.executeUpdate();
        }
    }

    public CafeDTO select(String product_name) throws Exception {
        String sql = "select * from tbl_cafe where product_name = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product_name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new CafeDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)
                );
            } else return null;
        }
    }
}
