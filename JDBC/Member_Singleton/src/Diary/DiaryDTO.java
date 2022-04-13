package Diary;

import java.sql.Date;

public class DiaryDTO {
    private int no;
    private Date written_date;
    private String title;
    private String content;

    public DiaryDTO() {
    }

    public DiaryDTO(int no, Date written_date, String title, String content) {
        this.no = no;
        this.written_date = written_date;
        this.title = title;
        this.content = content;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Date getWritten_date() {
        return written_date;
    }

    public void setWritten_date(Date written_date) {
        this.written_date = written_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return no + "\t" + written_date + "\t" + title +"\t" + content;
    }
}
