package com.kh.cafe;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01 {
    public static void main(String[] args) {
        /*  자바 프로그램 - DB 연동
            JDBC(Java Database Connectivity)
            자바에서 데이터베이스에 연결해 데이터를 주고 받을 수 있게 해주는 라이브러리
            -> SQL 명령문ㅇ르 자바에서 수행하면 DB 전달
            -> DBMS 종류에 따라서 JDBC 종류도 달라짐
            ex_ Oracle => OJDBC
        */
        // Connection 객체 생성 -> getConnection(url(DB의), Username, Userpw )

        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh")) {

            System.out.println("DB 접속 성공");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}