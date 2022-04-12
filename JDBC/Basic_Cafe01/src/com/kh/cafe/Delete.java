package com.kh.cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "kh";
        String pw = "kh";
        try(Connection connection = DriverManager.getConnection(url, username, pw);
            Statement stm = connection.createStatement();){

            System.out.println("DB 접속 성공");

            String sql = "delete from cafe where product_id = 2"; // OJDBC8에서는 AutoCommit 이 일어남.
            int rs = stm.executeUpdate(sql);

            if(rs>0) System.out.println("성공");
            else System.out.println("실패");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
