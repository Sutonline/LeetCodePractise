package cn.kevin.leetcode.easy;

import java.util.Arrays;

/**
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * created by yongkang.zhang
 * added at 2017/9/11
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        if (strs == null || strs.length == 0) {
            throw new UnsupportedOperationException("empty arrays received!!! ");
        }
        String firstStr = strs[0];
        int prefix = firstStr.length();
        while (prefix > 0 && commonPrefix.equals("")) {
            String tryStr = firstStr.substring(0, prefix);
            String s = Arrays.stream(strs).filter(str -> ! str.startsWith(tryStr)).findFirst().orElse(null);
            if (s != null) {
                prefix--;
            } else {
                commonPrefix = tryStr;
            }
        }

        return commonPrefix;
    }

    public static void main(String[] args) {
        String[] arrays = new String[]{"abc123", "ab30dk", "ab"};
        System.out.println(longestCommonPrefix(arrays));
    }
}
