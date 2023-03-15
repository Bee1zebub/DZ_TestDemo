package com.example.valueof;

public class TestValueOfRedix {
    public static void main(String[] args) {
        Long l = new Long(30);
        String str = "1110";
        /* returns a Long instance representing the specified string with radix 2 */
        System.out.println("Value = " + l.valueOf(str, 2));
    }
}
