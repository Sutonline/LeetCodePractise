package cn.kevin.leetcode.easy;

import java.util.stream.IntStream;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 * Note: Each term of the sequence of integers will be represented as a string.
 * created by yongkang.zhang
 * added at 2017/9/13
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        if (n < 1) {
            throw new UnsupportedOperationException("n must be greater or equals 1");
        }
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        char[] chars = s.toCharArray();
        int bitSum  = 0;
        char last = chars[0];
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == last) {
                bitSum += 1;
            } else {
                sb.append(bitSum).append(last);
                last = aChar;
                bitSum = 1;
            }
        }
        sb.append(bitSum).append(last);

        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(countAndSay(2));
        IntStream.range(1, 11).forEach(i -> System.out.println(countAndSay(i)));
    }
}
