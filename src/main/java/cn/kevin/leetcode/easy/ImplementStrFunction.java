package cn.kevin.leetcode.easy;

/**
 * Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * created by yongkang.zhang
 * added at 2017/9/12
 */
public class ImplementStrFunction {

    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.equals("") || needle == null || needle.equals("") || haystack.length() < needle.length()) {
            return -1;
        }
        int length = needle.length();
        for (int i = 0; i < haystack.length() - length + 1; i++) {
            if (haystack.substring(i, i + length).equals(needle))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("index of first occurence is: " + strStr("abcdef", "ef"));
    }
}
