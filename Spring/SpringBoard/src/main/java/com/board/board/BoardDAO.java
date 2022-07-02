package com.board.board;

import com.board.utils.DateConvert;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BoardDAO {
    @Autowired
    private BasicDataSource basicDataSource;
    @Autowired
    private DateConvert dateConvert;

    public int write(int seq_board, BoardDTO boardDTO) throws Exception {
        String sql = "insert into board values(?,?,?,?,?,0,sysdate)";
        try (Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, seq_board);
            preparedStatement.setString(2, boardDTO.getTitle());
            preparedStatement.setString(3, boardDTO.getContent());
            preparedStatement.setString(4, boardDTO.getWriter_nickname());
            preparedStatement.setString(5, boardDTO.getWriter_id());

            return preparedStatement.executeUpdate();
        }
    }

    public List<BoardDTO> selectAll(int start, int end) throws Exception {
        String sql = "select * from " +
                     "(select a.*, rownum as num from " +
                     "(select * from board order by 1 desc) a " +
                     "where rownum <= ?) " +
                     "where num >= ?";

        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, end);
            preparedStatement.setInt(2, start);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<BoardDTO> list = new ArrayList<>();

            while(resultSet.next()){

                int seq_board = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String content = resultSet.getString(3);
                String writer_nickname = resultSet.getString(4);
                String writer_id = resultSet.getString(5);
                int view_count =resultSet.getInt(6);
                String written_date = dateConvert.dateToString(resultSet.getDate(7));

                list.add(new BoardDTO(seq_board,title,content,writer_nickname,writer_id,view_count,written_date));

            } return list;
        }
    }

    public int countAll() throws Exception {
        String sql = "select count(*) from board";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return resultSet.getInt(1);
        }
    }

    public int nextSeq() throws Exception {
        String sql = "select SEQ_BOARD.nextval from dual";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return resultSet.getInt(1);
        }
    }

    public BoardDTO detail(int seq_bard) throws Exception {
        String sql = "select * from board where seq_board =?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,seq_bard);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int seq_board = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String content = resultSet.getString(3);
                String writer_nickname = resultSet.getString(4);
                String writer_id = resultSet.getString(5);
                int view_count =resultSet.getInt(6);
                String written_date = dateConvert.dateToString(resultSet.getDate(7));

                return new BoardDTO(seq_board,title,content,writer_id,writer_nickname,view_count,written_date);
            } return null;
        }
    }

    public int increaseViewCount(int seq_board) throws Exception {
        String sql = "update board set view_count= view_count+1 where seq_board = ?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, seq_board);

            return preparedStatement.executeUpdate();
        }
    }

    public int delete(int seq_board) throws Exception {
        String sql = "delete from board where seq_board = ?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, seq_board);

            return preparedStatement.executeUpdate();
        }
    }

    public int modify(BoardDTO boardDTO) throws Exception {
        String sql = "update board set title = ?, content = ? where SEQ_BOARD = ?";
        try(Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, boardDTO.getTitle());
            preparedStatement.setString(2, boardDTO.getContent());
            preparedStatement.setInt(3, boardDTO.getSeq_board());

            return preparedStatement.executeUpdate();
        }
    }
}
