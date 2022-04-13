package com.kh.cafe;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CafeDTO {
    private int product_id;
    private String product_name;
    private int price;
    private Date register_date;

    public CafeDTO() {
    }

    public CafeDTO(int product_id, String product_name, int price, Date register_date) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.register_date = register_date;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    @Override
    public String toString() {
        return product_id + "\t:" + product_name + "\t:" + price + "\t:" + parseDate(register_date) + "\t" + getTimestamp();
    }

    public String parseDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }

    // register_date 멤버 필드를 이용해서 현재 시간과 등록시간의 차이를 계산해 String 값으로 반환해주는 메서드
    public String getTimestamp() {
        // 현재 시간과 등록된 시간의 차이
        // System.currentTimeMills() -> 현재 시간이 long 형으로 반환됨
        // Date 값을 갖고 있는 register_date -> 일단 long 형으로 변환
        // getTime : 자바의 date 타입 데이터를 long 형으로 변환해서 반환해주는 메서드

        long origin_date = register_date.getTime();
        long cur_date = System.currentTimeMillis(); // 현재 시간
        long gap_time = (cur_date - origin_date) / 1000; // 두 시간의 갭을 초 단위로 계산


        //  1분 미만이면 ~ 초전
        if (gap_time < 60) return gap_time + "초 전";
            // 1시간 미만이면 ~분 전
        else if ((gap_time /= 60) < 60)
            return gap_time + "분 전";
        else if ((gap_time /= 60) < 24)
            return gap_time + "시간 전";
        else if ((gap_time /= 24) < 30)
            return gap_time + "일 전";
        else if ((gap_time /= 30) < 12)
            return gap_time + "달 전";
        else
            return gap_time / 12 + "년 전";
    }
}
