package com.example.date;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test01 {

    @DisplayName(value = "测试Date类")
    @Test
    public void test01(){
        Date date = new Date();
        System.out.println(date); //Mon Mar 13 13:55:18 CST 2023
        System.out.println(date.getTime());
    }

    @DisplayName(value = "测试 Calendar 类")
    @Test
    public void test02(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023,3,13);
        calendar.set(Calendar.YEAR,2025);
        calendar.add(Calendar.YEAR,2);
        System.out.println(calendar.getTime());
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
    }

    @DisplayName(value = "Date转String")
    @Test
    public void test03(){
        //Date 和 String转化
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy/MM/dd HH:mm:ss");
        String s = dateFormat.format(date);
        System.out.println(s);
    }

    @DisplayName(value = "String转Date")
    @Test
    public void test04() throws ParseException {
        String str="20211106";
        //String转Date时，格式必须一致。
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse(str);
        System.out.println(date.getTime());
    }
}
