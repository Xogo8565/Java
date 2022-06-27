package com.board.utils;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Component
public class DateConvert {
    public String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

        return simpleDateFormat.format(date);
    }
}
