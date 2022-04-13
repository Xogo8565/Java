package com.kh.cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username ="kh";
        String pw = "kh";

        try(Connection connection = DriverManager.getConnection(url, username, pw);
            Statement stm = connection.createStatement();){

            System.out.println("DB 접속");

            String sql = "Update cafe set product_name = '바닐라라떼', price = 4500 where product_id = 1";

            int rs = stm.executeUpdate(sql);

            if(rs>0) System.out.println("성공");
            else System.out.println("실패");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
