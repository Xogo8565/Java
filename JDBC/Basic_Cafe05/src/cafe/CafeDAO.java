package cafe;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CafeDAO {
    // Singleton

    private BasicDataSource basicDataSource = new BasicDataSource();
    private static CafeDAO instance = null;

    private CafeDAO() {//CafeDAO 생성자를 private 로 설정

        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("kh");
        basicDataSource.setPassword("kh");

        basicDataSource.setInitialSize(10);
    }

    public static CafeDAO getInstance(){
        //CafeDAO 인스턴스를 내부적으로 New 하고 반환하는 메서드
        //static　메서드로 설정
        if(instance == null){
            // CafeDAO 인스턴스가 생성되지 않았으면
            // == DBCP -> Connecting Pool 을 생성
            instance = new CafeDAO();
        }
        // 이미 존재한다면 이미 만들어진 Connection Pool을 통해 접속을 제공
        return instance;
    }

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
