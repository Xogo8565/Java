package com.board.dto;

public class MemberDTO {
    private String id;
    private String pw;
    private String nickname;
    private String phoneNum;
    private String postcode;
    private String address_1;
    private String address_2;
    private String address_3;

    public MemberDTO() {
    }

    public MemberDTO(String id, String pw, String nickname, String phoneNum, String postcode, String address_1, String address_2, String address_3) {
        this.id = id;
        this.pw = pw;
        this.nickname = nickname;
        this.phoneNum = phoneNum;
        this.postcode = postcode;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.address_3 = address_3;
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

    public String getPhone() {
        return phoneNum;
    }

    public void setPhone(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getAddress_3() {
        return address_3;
    }

    public void setAddress_3(String address_3) {
        this.address_3 = address_3;
    }
}
