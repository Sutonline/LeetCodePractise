package cn.kevin.leetcode.easy;

import java.util.regex.Pattern;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * created by yongkang.zhang
 * added at 2017/9/13
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        if (a == null || a.equals("") || b == null || b.equals("")) {
            throw new IllegalArgumentException("Not empty need!");
        }
        checkBinaryStyle(a);
        checkBinaryStyle(b);

        int aLength = a.length();
        int bLength = b.length();
        int addUp = 0;
        StringBuilder sb = new StringBuilder();
        int aint;
        int bint;
        for (int i = 0; i < (aLength > bLength ? a.length() : bLength); i++) {
            if (aLength - 1 - i >= 0) {
                aint = Integer.parseInt(a.substring(aLength - 1 - i, aLength - 1 - i + 1));
            } else {
                aint = 0;
            }

            if (bLength - 1 - i >= 0) {
                bint = Integer.parseInt(b.substring(bLength - 1 - i, bLength - 1 - i + 1));
            } else {
                bint = 0;
            }

            switch (aint + bint + addUp) {
                case 0:
                    sb.insert(0, "0");
                    addUp = 0;
                    break;
                case 1:
                    addUp = 0;
                    sb.insert(0, "1");
                    break;
                case 2:
                    sb.insert(0, "0");
                    addUp = 1;
                    break;
                case 3:
                    sb.insert(0, "1");
                    addUp = 1;
                    break;
            }

        }
        if (addUp == 1) sb.insert(0, "1");

        return sb.toString();
    }


    private static void checkBinaryStyle(String s) {
        String pattern = "[^0|1]";
        if (Pattern.matches(pattern, s)) {
            throw new IllegalArgumentException("String must be binary only");
        }
    }

    public static void main(String[] args) {
        System.out.println("Add up result is : " + addBinary("11", "11"));
    }
}
