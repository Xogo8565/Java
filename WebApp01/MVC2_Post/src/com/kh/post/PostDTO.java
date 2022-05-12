package com.kh.post;

public class PostDTO {
    private int no;
    private String id;
    private String msg;

    public PostDTO() {
    }

    public PostDTO(int no, String id, String msg) {
        this.no = no;
        this.id = id;
        this.msg = msg;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
