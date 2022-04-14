package com.fb.member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberDAO {
    private static MemberDAO instance = null;
    private static Connection connection = null;
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String username = "kh";
    private static String pw = "kh";

    public static MemberDAO getInstance() {
        if(instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }

    public static Connection getConnection() throws Exception{
        if(connection == null){
            connection = DriverManager.getConnection(url, username, pw);
        } return connection;
    }

    //회원가입 기능 수행
    public int signUp(MemberDTO dto) throws Exception {

        String sql = "insert into tbl_member values (seq_member.nextval,?,?,?)";
        try(Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPw());
            pstmt.setString(3, dto.getNickname());

            return  pstmt.executeUpdate();
        }
    }
    //아이디 중복 체크 -> 중복없으면 false return
    public boolean memberCheck(String id) throws Exception {

        String sql = "select * from tbl_member where id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            return !rs.next();
        }
    }
    //닉네임 중복체크
    public boolean nicknameCheck(String nickname) throws Exception {

        String sql = "select * from tbl_member where nickname = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nickname);
            ResultSet rs = pstmt.executeQuery();

            return !rs.next();
        }
    }
    //로그인 가능 여부
    public boolean login(String id, String pw) throws Exception{
        String sql = "select * from tbl_member where id = ? and pw = ?";

        try(Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();
        }
    }

    //닉네임 호출
    public String getNickname(String id) throws Exception {
        String sql = "select nickname from tbl_member where id = ?";

        try(Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                return rs.getString(1);
            }
            return null;
        }
    }
}