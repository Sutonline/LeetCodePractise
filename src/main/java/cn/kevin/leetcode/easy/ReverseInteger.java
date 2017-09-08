package cn.kevin.leetcode.easy;

import java.util.Objects;

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * created by yongkang.zhang
 * added at 2017/9/8
 */
public class ReverseInteger {

    private static int reverse(int x) {
        String prefix = "-";
        boolean negative = false;
        String max = "2147483647";
        String min = "-2147483647";
        int result = 0;
        if (x < 0) {
            negative = true;
        }
        String str = String.valueOf(Math.abs(x));
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(negative ? prefix : "");
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        if (sb.toString().compareTo(max) <= 0 && sb.toString().compareTo(min) <= 0) {
            result = Integer.parseInt(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-1000000003));
    }
}
