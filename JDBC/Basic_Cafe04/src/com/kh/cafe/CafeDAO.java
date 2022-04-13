package com.kh.cafe;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;

public class CafeDAO {
    /*
     * DBCP
     * Connection pool 을 이용해서 지정한 개수만큼 connection 객체를 생성해놓고
     * -> 선착순으로 접속한 클라이언트한테 가지고 있는 connection 을 분배해주고 그 뒤로 들어오는 클라이언트들은 앞에 접속했던 클라이언트들이 connection 을 반납할 때까지 대기
     *
     * dbcp2, logging, pool 라이브러리 추가
     * */

    //BasicDataSource 클래스 인스턴스 생성 -> DBCP 를 만들어주는 클래스
    private BasicDataSource basicDataSource = new BasicDataSource();

    // DBCP 를 구성하기 위해 필요한 설정값 세팅
    public CafeDAO() {
        //CafeDAO 생성자가 호출되면 자동으로 bds 에 설정값을 부여하도록
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("kh");
        basicDataSource.setPassword("kh");

        // 커넥션 개수 세팅
        basicDataSource.setInitialSize(10);
    }

    // 커넥션 풀에 있는 커넥션을 꺼내서 반환해주는 메서드
    public Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    public int insert(CafeDTO dto) throws Exception {
        String sql = "insert into cafe values(seq_cafe.nextval, ?, ?, sysdate)";
        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, dto.getProduct_name());
            preparedStatement.setInt(2, dto.getPrice());

            return preparedStatement.executeUpdate();
        }
    }

    public int update(CafeDTO dto) throws Exception {
        String sql = "update cafe set product_name = ?, price = ? where product_id = ?";

        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, dto.getProduct_name());
            preparedStatement.setInt(2, dto.getPrice());
            preparedStatement.setInt(3, dto.getProduct_id());

            return preparedStatement.executeUpdate();

        }
    }

    public int delete(int no) throws Exception { // 고유값이 되는 product_id를 기준으로 삭제,
        String sql = "delete from cafe where product_id = ?";

        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, no);

            return preparedStatement.executeUpdate();

        }
    }

    public CafeDTO select(int id) throws Exception {//1개 데이터 select
        String sql = "Select * from cafe where product_id = ?";

        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                int price = rs.getInt(3);
                Date register_date = rs.getDate(4);

                return new CafeDTO(product_id, product_name, price, register_date);
            }

            return null;
        }
    }

    public ArrayList<CafeDTO> selectAll() throws Exception {
        String sql = "select * from cafe";

        try (Connection connection = this.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ArrayList<CafeDTO> arrayList = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int product_no = rs.getInt(1);
                String product_name = rs.getString(2);
                int price = rs.getInt(3);
                Date register_date = rs.getDate(4);

                arrayList.add(new CafeDTO(product_no, product_name, price, register_date));
            }

            return arrayList;
        }
    }

}
