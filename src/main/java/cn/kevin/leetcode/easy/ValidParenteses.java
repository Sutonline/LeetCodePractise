package cn.kevin.leetcode.easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * created by yongkang.zhang
 * added at 2017/9/11
 */
public class ValidParenteses {


    public static boolean isValid(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (isLeft(c)) stack.push(c);
            if (isRight(c)) {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (! isMatch(left, c)) return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * 是否左边括号
     * @param left 字符
     * @return 是否
     */
    private static boolean isLeft(char left) {
        return left == '(' || left == '[' || left == '{';
    }

    /**
     * @param right 字符
     * @return 是否右边字符
     */
    private static boolean isRight(char right) {
        return right == ')' || right == ']' || right == '}';
    }

    /**
     * 是否匹配的括号
     * @param left 左字符
     * @param right 右字符
     * @return 是否匹配
     */
    private static boolean isMatch(char left, char right) {
        switch (left) {
            case '(': {
                if (right == ')') return true;
            }
            case '[': {
                if (right == ']') return true;
            }
            case '{': {
                if (right == '}') return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean valid = isValid("xxxx({})}");

        System.out.println(valid ? "valid" : "invalid");
    }
}
