package com.kh.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "kh";
        String pw = "kh";

        try(Connection connection = DriverManager.getConnection(url, username, pw);
            Statement stm = connection.createStatement()){
            System.out.println("DB 접속");

            String sql = "insert into tbl_student values(seq_std.nextval, 'michi' ,'010-5532-4156', to_date('1992-01-04','yy-mm-dd'))";
            int rs = stm.executeUpdate(sql);

            if(rs > 0) System.out.println("성공");
            else System.out.println("실패");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
