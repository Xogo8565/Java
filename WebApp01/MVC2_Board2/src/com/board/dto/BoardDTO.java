package com.board.dto;

import java.sql.Date;

public class BoardDTO {
    private int no;
    private String id;
    private String nickname;
    private String title;
    private String content;
    private int view_count;
    private String written_date;

    public BoardDTO() {
    }

    public BoardDTO(int no, String id, String nickname, String title, String content, int view_count, String written_date) {
        this.no = no;
        this.id = id;
        this.nickname = nickname;
        this.title = title;
        this.content = content;
        this.view_count = view_count;
        this.written_date = written_date;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public String getWritten_date() {
        return written_date;
    }

    public void setWritten_date(String written_date) {
        this.written_date = written_date;
    }
}
