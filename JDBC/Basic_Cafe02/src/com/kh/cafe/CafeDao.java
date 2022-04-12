package com.kh.cafe;

import java.sql.*;
import java.util.ArrayList;

public class CafeDao {

    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "kh";
    private String pw = "kh";

    public int insert(CafeDTO dto) throws Exception {
        try(Connection connection = DriverManager.getConnection(url, username, pw);
            Statement stm = connection.createStatement()){
            String sql = "insert into cafe values(seq_cafe.nextval, '" +
                    dto.getProduct_name() + "', " +
                    dto.getPrice() + ", " +
                    "sysdate)";
            return stm.executeUpdate(sql);
        }
    }

    public int update(CafeDTO dto) throws Exception {
        try(Connection connection = DriverManager.getConnection(url, username, pw);
            Statement stm = connection.createStatement()){
            String sql = "update cafe set product_name = '" + dto.getProduct_name() +
                    "', price = " + dto.getPrice() +
                    " where product_id = " + dto.getProduct_id();
            return stm.executeUpdate(sql);
        }
    }

    public int delete(int no) throws Exception { // 고유값이 되는 product_id를 기준으로 삭제,
        try(Connection connection = DriverManager.getConnection(url, username, pw);
        Statement stm = connection.createStatement();){
            String sql = "delete from cafe where product_id = '" + no + "'";
            return stm.executeUpdate(sql);
        }
    }

    public CafeDTO select(int id) throws Exception {//1개 데이터 select
        try(Connection connection = DriverManager.getConnection(url, username, pw);
        Statement stm = connection.createStatement();){

            String sql = "Select * from cafe where product_id = " +id;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()){
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                int price = rs.getInt(3);
                Date register_date = rs.getDate(4);

                CafeDTO dto = new CafeDTO(product_id,product_name,price,register_date);
                return  dto;
            }

            return null;
        }
    }

    public ArrayList<CafeDTO> selectAll() throws Exception {
        try(Connection connection = DriverManager.getConnection(url,username,pw);
        Statement stm = connection.createStatement();){

            String sql = "select * from cafe";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<CafeDTO> arrayList= new ArrayList<>();

            while(rs.next()){
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                int price = rs.getInt(3);
                Date register_date = rs.getDate(4);

                arrayList.add(new CafeDTO(product_id, product_name, price, register_date));
            }
            return arrayList;
        }
    }
}
