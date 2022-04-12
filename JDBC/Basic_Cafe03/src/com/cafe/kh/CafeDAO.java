package com.cafe.kh;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CafeDAO {

    private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String username = "kh";
    private final String pw = "kh";

    // Statement : SQL injection 에 취약 (보안 이슈)
    // PreparedStatement -> 객체를 생성할 때 인자값으로 넘겨주는 SQL 문(쿼리문)을 미리 DBMS 에 컴파일하여 올려 둠.
    // ? -> 추후에 인자값을 세팅해 줄 자리 표시
    //   -> 물음표 자리에 Set 되는 값은 말 그대로 값 그자체로 들어가게 됨(문자열 인식)
    //   -> 5555 or 1 = 1 -> 이러한 식을 넣어도 값으로만 인식이 되기 때문에 SQL Injection 에 대한 방지처리가 됨.
    // Statement 객체보다 PreparedStatement 객체가 가독성도 높음


    public int insert(CafeDTO dto) throws Exception {
        String sql = "insert into cafe values(seq_cafe.nextval, ?, ?, sysdate)";
        // PreparedStatement 객체는 쿼리문을 인자값으로 하여 생성
        try(Connection connection = DriverManager.getConnection(url, username, pw);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            // ? 에 해당하는 인자값 생성
            // preparedStatement.set자료형(물음표의 인덱스, 그 물음표에 세팅해줄 값);
            preparedStatement.setString(1, dto.getProduct_name());
            preparedStatement.setInt(2, dto.getPrice());
            // 쿼리문을 실행 -> 이미 완성된 쿼리문을 PreparedStatement 객체가 갖고 있기 때문에(인자값으로 갖고 있기 때문에) 그 쿼리문을 실행만 시켜주면 됨.
            return preparedStatement.executeUpdate();
        }
    }

    public int update(CafeDTO dto) throws Exception {
        String sql = "update cafe set product_name = ?, price = ? where product_id = ?";

        try(Connection connection = DriverManager.getConnection(url, username, pw);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, dto.getProduct_name());
            preparedStatement.setInt(2,dto.getPrice());
            preparedStatement.setInt(3,dto.getProduct_id());

            return preparedStatement.executeUpdate();

        }
    }

    public int delete(int no) throws Exception { // 고유값이 되는 product_id를 기준으로 삭제,
        String sql = "delete from cafe where product_id = ?";

        try(Connection connection = DriverManager.getConnection(url, username, pw);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1,no);

            return preparedStatement.executeUpdate();

        }
    }

    public CafeDTO select(int id) throws Exception {//1개 데이터 select
        String sql = "Select * from cafe where product_id = ?";

        try(Connection connection = DriverManager.getConnection(url, username, pw);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                int price = rs.getInt(3);
                Date register_date = rs.getDate(4);

                return new CafeDTO(product_id,product_name,price,register_date);
            }

            return null;
        }
    }

    public ArrayList<CafeDTO> selectAll() throws Exception {
        String sql = "select * from cafe";


        try (Connection connection = DriverManager.getConnection(url, username, pw); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ArrayList<CafeDTO> arrayList = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int product_no = rs.getInt(1);
                String product_name = rs.getString(2);
                int price = rs.getInt(3);
                Date register_date = rs.getDate(4);

                arrayList.add(new CafeDTO(product_no,product_name,price,register_date));
            }

            return arrayList;
        }
    }

}
