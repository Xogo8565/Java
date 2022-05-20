package com.board.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateToString {
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        return simpleDateFormat.format(date);
    }
}
