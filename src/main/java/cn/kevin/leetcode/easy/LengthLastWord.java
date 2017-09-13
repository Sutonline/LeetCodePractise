package cn.kevin.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example,
 * Given s = "Hello World",
 * return 5.
 * created by yongkang.zhang
 * added at 2017/9/13
 */
public class LengthLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) {
            throw new IllegalArgumentException("String parameter s cannot be null or empty");
        }

        int last = s.lastIndexOf(' ');
        if (last == s.length()) return 0;
        return s.substring(last + 1).length();
    }


    public static void main(String[] args) {
        System.out.println("length of last word length is: " + lengthOfLastWord("Hello World"));
    }

}
