package com.example.valueof;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestValueOf {

    @JsonSerialize
    public static void main(String[] args) {
        Long aLong = Long.valueOf(1223L);
        Long bLong = Long.valueOf("3123");
        Long cLong = Long.valueOf("123456", 3);
        aLong.longValue();
        System.out.println(aLong);
        System.out.println(bLong.getClass());
        System.out.println(cLong);
        String s = aLong.toString();
        System.out.println(s);
        String s1 = String.valueOf(aLong);
        System.out.println(s1);
        String s2 = String.valueOf(aLong);
        System.out.println(s2);
    }
}
