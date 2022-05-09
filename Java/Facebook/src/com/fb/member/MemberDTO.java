package com.fb.member;

public class MemberDTO {
    private int no;
    private String id;
    private String pw;
    private String nickname;

    public MemberDTO() {}

    public MemberDTO(int no, String id, String pw, String nickname) {
        this.no = no;
        this.id = id;
        this.pw = pw;
        this.nickname = nickname;
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

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}