package com.kh.dao;

public class MessageDTO {
    private String nickname;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(String nickname, String message) {
        this.nickname = nickname;
        this.message = message;
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

    @Override
    public String toString() {
        return  nickname + " : " + message;
    }
}
