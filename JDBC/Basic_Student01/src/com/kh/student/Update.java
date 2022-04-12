package com.kh.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "kh";
        String pw = "kh";
        try(Connection connection = DriverManager.getConnection(url, username, pw);
        Statement stm = connection.createStatement();){

            String sql = "Update tbl_student set " +
                    "name = '김영수', phone = '010-1234-1234', birth_date = to_date('1985/12/20','yyyy-mm-dd')";
            int rs = stm.executeUpdate(sql);

            if(rs > 0) System.out.println("성공");
            else System.out.println("실패");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
