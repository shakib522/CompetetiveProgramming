package src.main.kotlin.leetcode;

import java.util.Collections;

public class AtoI {
    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }

    public static int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '-') {
                    sign = -1;
                } else if (s.charAt(i) == '+') {
                    sign=1;
                } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    return 0;
                } else {
                    builder.append(s.charAt(i));
                }
            } else {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    break;
                } else {
                    builder.append(s.charAt(i));
                }
            }
        }
        long number = 0;
        for (int i = 0; i < builder.length(); i++) {
            number = (number * 10) + (builder.charAt(i) - '0');
            if (number*sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (number*sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        number = number * sign;
        return (int) number;
    }
}
