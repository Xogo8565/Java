package com.kh.cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "kh";
        String pw = "kh";
        try(Connection connection = DriverManager.getConnection(url,username,pw);
            Statement stm = connection.createStatement();){

            System.out.println("DB 접속");

            // product_id 1번인 메뉴 정보 가져오기
/*  #1 한 줄씩 출력
            String sql = "select * from cafe where product_id = 1";
            // 반환값이 ResultSet(질의 결과)
            ResultSet rs = stm.executeQuery(sql);
            System.out.println("rs : " + rs); // ResultSet 의 주소값 반환
            //ResultSet 이 반환될 때 커서라는 개념이 존재
            // 이 커서는 가장 첫번째 행의 바로 윗쪽을 가리키고 있음
            // 첫번째 행을 가리키고 싶으면 커서를 내려줘여 함 -> rs.next();

//            System.out.println("rs.next : " + rs.next()); // true
            // System.out.println("rs.next : " + rs.next()); // false
            //rs.next() 이 반환하는 값은 true / false
            //다음 행에 값이 있으면 true, 없으면 false

            // 커서가 데이터를 가리키고 있는 상태에서 값을 얻어내는 방법
            // 1. 오라클의 인덱서를 사용하는 방법 (product_id(1), product_name(2), price(3), register_date(4))
//            System.out.println(rs.getInt(1)); //id
//            System.out.println(rs.getString(2)); //name
//            System.out.println(rs.getInt(3));// price
//            System.out.println(rs.getDate(4)); // register_date

            // 만약 커서를 내렸을 때 행이 존재하다면 값을 출력
//            if(rs.next()){
//                System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getDate(4));
//            }

            // 2. 컬럼명을 활용하는 방법
            if(rs.next()){
                System.out.println(rs.getInt("product_id") + " : " +
                        rs.getString("product_name") + " : " +
                        rs.getInt("price") + " : " +
                        rs.getDate("register_date"));
            }
            */

            /*
            반복문 활용 -> 전체 row 출력
            */
            String sql = "select * from cafe";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt(1) + " : " +
                        rs.getString(2) + " : " +
                        rs.getInt(3) + " : " +
                        rs.getDate(4));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
