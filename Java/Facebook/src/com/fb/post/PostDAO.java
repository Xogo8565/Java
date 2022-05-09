package com.fb.post;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.fb.member.MemberDAO;

public class PostDAO {
    MemberDAO memberDAO = MemberDAO.getInstance();
    private PostDAO(){
    }

    private static class PostDaoHolder{
        private static final PostDAO INSTANCE= new PostDAO();
    }

    public static PostDAO getInstance(){
        return PostDaoHolder.INSTANCE;
    }

    // 게시물 생성
    public int createPost(PostDTO postDTO) throws Exception {
        String sql = "insert into tbl_post values(seq_post.nextval, ?, ?, ?, sysdate)";

        try(Connection connection = memberDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setString(1, postDTO.getTitle());
            preparedStatement.setString(2, postDTO.getContent());
            preparedStatement.setString(3, postDTO.getNickname());

            return preparedStatement.executeUpdate();

        }
    }

    // 게시물 삭제
    public int deletePost(int no) throws Exception {
        String sql = "delete from tbl_post where no = ?";
        try (Connection con = memberDAO.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);){

            pst.setInt(1, no);
            return pst.executeUpdate();
        }
    }


    // 게시물 조회 관련 로직
    public PostDTO readPost(int no) throws Exception {
        String sql = "select * from tbl_post where no = ?";

        try (Connection con = memberDAO.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);){

            pst.setInt(1, no);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int postNo = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                String nickname = rs.getString(4);
                String written_date = parseDate(rs.getDate(5));

                return  new PostDTO(postNo, title, content, nickname, written_date);
            }
            return null;
        }
    }

    // 전체 게시글 조회
    public ArrayList<PostDTO> postList() throws Exception {
        String sql = "select * from tbl_post";

        try(Connection connection = memberDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            ArrayList<PostDTO> arrayList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int no = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String content = resultSet.getString(3);
                String nickname = resultSet.getString(4);
                String date = parseDate(resultSet.getDate(5));

                arrayList.add(new PostDTO(no,title,content,nickname,date));
            }
            return arrayList;
        }
    }

    // 오라클 Date 형변환 (Date -> String)

    public String parseDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public int updatePost(PostDTO dto) throws Exception {
        String sql = "update tbl_post set title = ?, content = ? where no = ?";

        try(Connection connection = memberDAO.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);){

            pst.setString(1, dto.getTitle());
            pst.setString(2,dto.getContent());
            pst.setInt(3, dto.getNo());

            return pst.executeUpdate();
        }
    }
}