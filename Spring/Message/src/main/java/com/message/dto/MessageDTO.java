package com.message.dto;

public class MessageDTO {
    private int seq_msg;
    private String nickname;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(int seq_msg, String nickname, String message) {
        this.seq_msg = seq_msg;
        this.nickname = nickname;
        this.message = message;
    }

    public int getSeq_msg() {
        return seq_msg;
    }

    public void setSeq_msg(int seq_msg) {
        this.seq_msg = seq_msg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
