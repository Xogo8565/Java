package com.fb.post;

public class PostDTO {
    private int no;
    private String title;
    private String content;
    private String nickname;
    private String written_date;

    public PostDTO() {}

    public PostDTO(int no, String title, String content, String nickname, String written_date) {
        super();
        this.no = no;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.written_date = written_date;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWritten_date() {
        return written_date;
    }

    public void setWritten_date(String written_date) {
        this.written_date = written_date;
    }

    public String toStringlist() {
        return no + "\t" + title + "\t\t" + nickname + "\t" + written_date;
    }

    public String toStringPost() {
        return "글번호\t" + no
                + "\n닉네임\t" +  nickname
                + "\n등록일\t" + written_date
                + "\n타이틀\t" + title
                + "\n내용\t" + content;
    }

}