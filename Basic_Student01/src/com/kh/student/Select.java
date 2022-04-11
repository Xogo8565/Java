package com.kh.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "kh";
        String pw = "kh";

        try(Connection connection = DriverManager.getConnection(url, username, pw);
            Statement stm = connection.createStatement();){
            String sql1 = "select * from tbl_student where no = 1";
            String sql2 = "select * from tbl_student";

            //#1

            ResultSet rs1 = stm.executeQuery(sql1);
            if(rs1.next()){
                System.out.println(rs1.getInt(1) + " : " + rs1.getString(2) + " : " + rs1.getString(3) + " : " + rs1.getDate(4));
            }
            System.out.println("=====================================================\n ");

            //#2

            ResultSet rs2 = stm.executeQuery(sql2);
            while (rs2.next()){
                System.out.println(rs2.getInt(1) + " : " + rs2.getString(2) + " : " + rs2.getString(3) + " : " + rs2.getDate(4));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
