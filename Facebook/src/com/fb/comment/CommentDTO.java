package com.fb.comment;

public class CommentDTO {
    private int comment_no;
    private int post_no;
    private String comment_content;
    private String nickname;
    private String written_date;

    public CommentDTO() {}

    public CommentDTO(int comment_no, int post_no, String comment_content, String nickname, String written_date) {
        super();
        this.comment_no = comment_no;
        this.post_no = post_no;
        this.comment_content = comment_content;
        this.nickname = nickname;
        this.written_date = written_date;
    }

    public int getComment_no() {
        return comment_no;
    }

    public void setComment_no(int comment_no) {
        this.comment_no = comment_no;
    }

    public int getPost_no() {
        return post_no;
    }

    public void setPost_no(int post_no) {
        this.post_no = post_no;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
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

    public String toString() {
        return comment_content + "\t\t\t" + nickname + "\t" + written_date;
    }

}