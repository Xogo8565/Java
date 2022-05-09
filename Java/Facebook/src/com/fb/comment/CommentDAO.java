package com.fb.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fb.member.MemberDAO;
import org.apache.commons.dbcp2.BasicDataSource;

public class CommentDAO {

    MemberDAO memberDAO = MemberDAO.getInstance();

    private CommentDAO() {
    }

    private static class CommentDaoHolder {
        private static final CommentDAO INSTANCE = new CommentDAO();
    }

    public static CommentDAO getInstance() {
        return CommentDaoHolder.INSTANCE;
    }

    // 오라클 date -> 자바 String 변환
    public String parseDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm");
        return sdf.format(date);
    }

    // 댓글 등록 기능 구현
    public int createComment(CommentDTO dto) throws Exception {

        String sql = "insert into tbl_comment values(seq_comment.nextval, ?, ?, ?, sysdate)";
        try (Connection con = memberDAO.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setInt(1, dto.getPost_no());
            pstmt.setString(2, dto.getComment_content());
            pstmt.setString(3, dto.getNickname());

            return pstmt.executeUpdate();
        }
    }

    // 댓글 출력 기능 구현
    public ArrayList<CommentDTO> readComment(int post_no) throws Exception {

        String sql = "select * from tbl_comment where post_no = ?";
        try (Connection con = memberDAO.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setInt(1, post_no);

            ResultSet rs = pstmt.executeQuery();

            ArrayList<CommentDTO> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new CommentDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getNString(4), parseDate(rs.getDate(5))));
            }
            return list;
        }
    }

}