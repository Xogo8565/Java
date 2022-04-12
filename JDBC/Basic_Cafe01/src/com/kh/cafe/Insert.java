package com.kh.cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "kh";
        String password = "kh";
        // Connectino 객체 생성 -> url, username, pw
        // Statement 객체 -> 오라클에 sql 문을 전송하고 쿼리의 결과를 요청할 수 있게 해주는 객체 // java.sql.statement
        // cafe 테이블에서 새로운 데이터 insert ( seq_cafe.nextval, '아이스아메리카노', 3000, sysdate)
        try(Connection connection = DriverManager.getConnection(url,username,password);
            Statement stm = connection.createStatement();){

            System.out.println("접속성공");

            String sql = "insert into cafe values (seq_cafe.nextval, '바닐라 라떼', 3000, sysdate)";
            int rs = stm.executeUpdate(sql);// insert, update, delete ( 행에 변화가 생기는 쿼리 ) 를 사용할 때 사용하는 메서드
            // executeUpdate() 메서드의 반환값 = 인자값으로 넘겨준 쿼리문을 통해서 영향을 받은 행의 개수를 int 형으로 반환

            if(rs > 0)
                System.out.println("데이터 추가 성공");
            else
                System.out.println("데이터 추가 실패");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
