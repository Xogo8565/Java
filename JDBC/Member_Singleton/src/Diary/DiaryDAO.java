package Diary;

import member.MemberDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DiaryDAO {
    private static DiaryDAO instatnce = null;
    public MemberDAO memberDAO = MemberDAO.getInstance();

    public static DiaryDAO getInstance() {
        if (instatnce == null) {
            instatnce = new DiaryDAO();
        }
        return instatnce;
    }

    public int newDiary(DiaryDTO diaryDTO) throws Exception {
        String sql = "insert into tbl_diary values(seq_diary.nextval, ?,?,?)";

        try (Connection connection = memberDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setDate(1, diaryDTO.getWritten_date());
            preparedStatement.setString(2, diaryDTO.getTitle());
            preparedStatement.setString(3, diaryDTO.getContent());

            return preparedStatement.executeUpdate();

        }
    }

    public DiaryDTO select(int no) throws Exception {
        String sql = "select * from tbl_diary where no = ?";

        try (Connection connection = memberDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, no);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Date written_date = resultSet.getDate(2);
                String title = resultSet.getString(3);
                String content = resultSet.getString(4);

                return new DiaryDTO(no, written_date, title, content);
            }
            return null;
        }
    }

    public ArrayList<DiaryDTO> selectAll() throws Exception {
        String sql = "select * from tbl_diary";

        try (Connection connection = memberDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<DiaryDTO> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                int no = resultSet.getInt(1);
                Date written_date = resultSet.getDate(2);
                String title = resultSet.getString(3);
                String content = resultSet.getString(4);

                arrayList.add(new DiaryDTO(no,written_date,title,content));
            }
            return arrayList;
        }
    }
}
