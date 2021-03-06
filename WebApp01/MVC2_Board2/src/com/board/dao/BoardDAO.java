package com.board.dao;

import com.board.dto.BoardDTO;
import com.board.utils.DateToString;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardDAO {
    private BasicDataSource basicDataSource;

    public BoardDAO() {
        try {
            Context context = new InitialContext();
            Context envContext = (Context) context.lookup("java:comp/env");
            basicDataSource = (BasicDataSource) envContext.lookup("jdbc/bds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }

    public int getBoardSeq() throws Exception {
        String sql = "select seq_board.nextval from dual";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();

         return resultSet.getInt(1) ;
        }
    }

    public int newPost(BoardDTO boardDTO) throws Exception {
        String sql = "insert into tbl_board values(?,?,?,?,?,0,sysdate)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, boardDTO.getNo());
            preparedStatement.setString(2, boardDTO.getId());
            preparedStatement.setString(3, boardDTO.getNickname());
            preparedStatement.setString(4, boardDTO.getTitle());
            preparedStatement.setString(5, boardDTO.getContent());

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<BoardDTO> selectAll(int start, int end) throws Exception {
        String sql = "select * from " + "(select A.*, rownum as num from " + "(select * from tbl_board order by 1 desc) A) where num between ? and ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, end);

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BoardDTO> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int no = resultSet.getInt(1);
                String id = resultSet.getString(2);
                String nickname = resultSet.getString(3);
                String title = resultSet.getString(4);
                String content = resultSet.getString(5);
                int view_count = resultSet.getInt(6);
                String written_date = DateToString.dateToString(resultSet.getDate(7));

                arrayList.add(new BoardDTO(no, id, nickname, title, content, view_count, written_date));
            }

            return arrayList;
        }
    }

    public BoardDTO selectByNo(int no) throws Exception {
        String sql = "select * from tbl_board where no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, no);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString(2);
                String nickname = resultSet.getString(3);
                String title = resultSet.getString(4);
                String content = resultSet.getString(5);
                int view_count = resultSet.getInt(6);
                String written_date = DateToString.dateToString(resultSet.getDate(7));

                return new BoardDTO(no, id, nickname, title, content, view_count, written_date);
            }
            return null;
        }
    }

    public int modifyPost(BoardDTO boardDTO) throws Exception {
        String sql = "update tbl_board set title = ?, content =? where no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, boardDTO.getTitle());
            preparedStatement.setString(2, boardDTO.getContent());
            preparedStatement.setInt(3, boardDTO.getNo());

            return preparedStatement.executeUpdate();
        }
    }

    public int deletePost(int no) throws Exception {
        String sql = "delete from tbl_board where no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, no);

            return preparedStatement.executeUpdate();
        }
    }

    public int plusViewCount(int no) throws Exception {
        String sql = "update tbl_board set view_count = view_count+1 where no = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, no);

            return preparedStatement.executeUpdate();
        }
    }

    public ArrayList<BoardDTO> searchByTitle(String search) throws Exception {
        String sql = "select * from tbl_board where title like ? order by 1 desc";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + search + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BoardDTO> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                int no = resultSet.getInt(1);
                String id = resultSet.getString(2);
                String nickname = resultSet.getString(3);
                String title = resultSet.getString(4);
                String content = resultSet.getString(5);
                int view_count = resultSet.getInt(6);
                String written_date = DateToString.dateToString(resultSet.getDate(7));

                arrayList.add(new BoardDTO(no, id, nickname, title, content, view_count, written_date));
            }

            return arrayList;
        }
    }

    public HashMap<String, Object> getPageNavi(int curPage) throws Exception {
        String sql = "select count(*) as totalCnt from tbl_board";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            // ?????? ???????????? ??????
            int totalCnt = resultSet.getInt(1);
            int recordPerPage = 10; // ??? ??????????????? ?????? ??? ???????????? ???
            int naviCntPerPage = 5; // ??? ??????????????? ?????? ??? ????????? ??????
            int totalPage = totalCnt / recordPerPage + (totalCnt % recordPerPage == 0 ? 0 : 1); // ??? ????????? ???

            // curPage ??????
            if (curPage < 1) curPage = 1;
            else if (curPage > totalPage) curPage = totalPage;

            // ?????? ???????????? ???????????? ????????? ?????? ?????????, ??? ????????? ??????
            int navStart = ((curPage - 1) / naviCntPerPage) * naviCntPerPage + 1;
            int navEnd = navStart + (naviCntPerPage - 1);

            //navEnd ??? ?????? ???????????? ?????? ??? ??????
            if (navEnd > totalPage) navEnd = totalPage;


            //prevBtn, nextBtn
            boolean prevBtn = (navStart == 1 ? false : true);
            boolean nextBtn = (navEnd == totalPage ? false : true);

            HashMap<String, Object> hashMap = new HashMap<>();

            hashMap.put("navStart", navStart);
            hashMap.put("navEnd", navEnd);
            hashMap.put("prevBtn", prevBtn);
            hashMap.put("nextBtn", nextBtn);

            int start = (curPage - 1) * recordPerPage + 1;
            int end = start + (recordPerPage - 1);

            hashMap.put("start", start);
            hashMap.put("end", end);

            return hashMap;
        }
    }

}
