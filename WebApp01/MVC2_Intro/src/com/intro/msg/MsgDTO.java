package com.intro.msg;

public class MsgDTO {
    private int no;
    private String nickname;
    private String msg;

    public MsgDTO() {
    }

    public MsgDTO(int no, String nickname, String msg) {
        this.no = no;
        this.nickname = nickname;
        this.msg = msg;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "msgDTO{" +
                "no=" + no +
                ", nickname='" + nickname + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
