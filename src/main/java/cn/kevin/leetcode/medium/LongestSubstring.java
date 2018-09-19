package cn.kevin.leetcode.medium;

import java.util.LinkedList;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author yongkang.zhang
 * created at 19/09/2018
 */
public class LongestSubstring {

    /**
     * 使用LinkedList应该效果最好
     *
     * @param input 输入的字符串
     * @return 返回String
     */
    private static void findLongestSubstring(String input) {
        int tempCount = 0;
        LinkedList<String> tempList = new LinkedList<>();
        String[] split = input.split("");

        for (String s : split) {
            if (tempList.contains(s)) {
                while (tempList.contains(s)) {
                    tempList.pop();
                }
            }

            tempList.add(s);

            if (tempList.size() > tempCount) {
                tempCount = tempList.size();
            }
        }

        System.out.println("最大长度是: " + tempCount);

        System.out.println(String.join("", tempList));
    }

    public static void main(String[] args) {
        findLongestSubstring("pwwkewx");
    }
}
