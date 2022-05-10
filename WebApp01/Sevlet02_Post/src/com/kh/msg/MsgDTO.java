package com.kh.msg;

public class MsgDTO {
    private String id;
    private String msg;

    public MsgDTO() {
    }

    public MsgDTO(String id, String msg) {
        this.id = id;
        this.msg = msg;
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

    @Override
    public String toString() {
        return id + ":" + msg;
    }
}
