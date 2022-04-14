
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;

public class LaptopDAO {
    private BasicDataSource bds = new BasicDataSource();

    public LaptopDAO() {

        bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        bds.setUsername("kh");
        bds.setPassword("kh");
        bds.setInitialSize(10);

    }

    public Connection getConnection() throws Exception {
        return bds.getConnection();
    }

    public int register(LaptopDTO dto) throws Exception { //  노트불 등록
        String sql = "insert into laptop values(seq_laptop.nextval, ?, ?, to_date(?))";
        try (Connection con = this.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, dto.getLaptop_name());
            pstmt.setInt(2, dto.getLaptop_price());
            pstmt.setString(3, dto.getLaptop_mfd());

            int rs = pstmt.executeUpdate();
            return rs;
        }
    }

    public boolean checkName(String name) throws Exception { // 노트북 이름 중복체크
        String sql = "select * from laptop where laptop_name = ?";
        try (Connection con = this.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return false;
            }
            return true;
        }
    }

    public LaptopDTO selectByNo(int no) throws Exception { // 노트북 번호로 정보 가져오기
        String sql = "select * from laptop where laptop_no = ?";
        try (Connection con = this.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setInt(1, no);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new LaptopDTO(no, rs.getString(2), rs.getInt(3), parseDate(rs.getDate(4)));
            }
            return null;
        }
    }

    public ArrayList<LaptopDTO> selectAll() throws Exception { // 모든 노트북 정보 가져오기
        String sql = "select * from laptop";
        try (Connection con = this.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {

            ResultSet rs = pstmt.executeQuery();
            ArrayList<LaptopDTO> list = new ArrayList<>();
            while(rs.next()) {
                list.add(new LaptopDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), parseDate(rs.getDate(4))));            }
            return list;
        }
    }

    public String parseDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return simpleDateFormat.format(date);

    }
}