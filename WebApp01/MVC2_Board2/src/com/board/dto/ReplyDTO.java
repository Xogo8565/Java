package com.board.dto;

public class ReplyDTO {
    private int reply_no;
    private int board_no;
    private String content;
    private String id;
    private String nickname;
    private String written_date;

    public ReplyDTO() {
    }

    public ReplyDTO(int reply_no, int board_no, String content, String id, String nickname, String written_date) {
        this.reply_no = reply_no;
        this.board_no = board_no;
        this.content = content;
        this.id = id;
        this.nickname = nickname;
        this.written_date = written_date;
    }

    public int getReply_no() {
        return reply_no;
    }

    public void setReply_no(int reply_no) {
        this.reply_no = reply_no;
    }

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getWritten_date() {
        return written_date;
    }

    public void setWritten_date(String written_date) {
        this.written_date = written_date;
    }
}

