package cn.kevin.leetcode.easy;

import java.util.Arrays;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * created by yongkang.zhang
 * added at 2017/9/13
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            int add = digits[i] + 1;
            if (add >= 10) {
                digits[i] = add - 10;
                if (i == 0) {
                    int[] newDigit = new int[digits.length + 1];
                    System.arraycopy(newDigit, 1, digits, 0, digits.length);
                    newDigit[0] = 1;
                    return newDigit;
                }
            } else {
                digits[i] = add;
                return digits;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("After plus one, new array is: " + Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
}
