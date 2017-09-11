package cn.kevin.leetcode.easy;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999
 * created by yongkang.zhang
 * added at 2017/9/8
 */
public class RomanToInteger {

    private static int romanToInt(String s) {
        int sum = 0;
        if (s == null || s.equals("")) {
            throw new UnsupportedOperationException("empty input received!!! ");
        }
        checkAllowCharacter(s);
        checkMaxContinous(s);
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length; i++){
            char left = chars[i];
            int leftResult = toInt(left);
            int result = 0;
            if (i < chars.length - 1) {
                char right = chars[i + 1];
                int rigthResult = toInt(right);
                //如果右边数字大
                if (rigthResult > leftResult) {
                    result = toInt(left, right);
                    i++; // i+1这一位已经计算
                } else {
                    result = leftResult;
                }
            } else {
                result = toInt(left);
            }

            //这里坐一下数字大小顺序检查
            if (sum > 0) checkOrder(sum, result);
            sum += result;
        }

        return sum;
    }


    /**
     * rule 1: 合法字符
     * @param romanStr 罗马数字
     */
    private static void checkAllowCharacter(String romanStr) {
        String pattern = "[^I|VXLCDM]";
        boolean matches = Pattern.matches(pattern, romanStr);
        if (matches) {
            throw new UnsupportedOperationException("Only 'I', 'V', 'X', 'L', 'C', 'D', 'M' can be accepted");
        }
    }

    /**
     * rule 2: 同样的数字最多只能出现三位
     * @param romanStr 罗马字符串
     */
    private static void checkMaxContinous(String romanStr) {
        String pattern = "I{4,}|V{4,}|X{4,}|L{4,}|C{4,}|D{4,}|M{4,}";
        boolean matches = Pattern.matches(pattern, romanStr);
        if (matches) {
            throw new UnsupportedOperationException("Same char together limit to 3");
        }
    }

    /**
     * rule 3: 检查左减类型
     */
    private static void checkSubStyle(char a, char b) {
        String str = String.valueOf(a) + String.valueOf(b);
        if (! str.equalsIgnoreCase("ix")
                && ! str.equalsIgnoreCase("xl")
                && ! str.equalsIgnoreCase("cd")
                && ! str.equalsIgnoreCase("iv")
                && ! str.equalsIgnoreCase("xc")
                && ! str.equalsIgnoreCase("cm")) {
            throw new UnsupportedOperationException("invalid substraction");
        }
    }

    /**
     * rule 4: 大数字必须在前
     * @param sum 当前求和的值
     * @param add 被加数
     */
    private static void checkOrder(int sum, int add) {
        if (sum < add) {
            throw new UnsupportedOperationException("illegal input order, large number first");
        }
    }

    /**
     * 计算args的值
     * @param args 参数
     * @return 被加数的值
     */
    private static int toInt(char... args){
        int result = 0;
        if (args.length <= 0 || args.length > 2) {
            throw new UnsupportedOperationException("one digit's bit must less than two");
        }
        if (args.length == 1) {
            char roman = args[0];
            switch (roman) {
                case 'I': {
                    result = 1;
                    break;
                }
                case 'V': {
                    result = 5;
                    break;
                }
                case 'X': {
                    result = 10;
                    break;
                }
                case 'L': {
                    result = 50;
                    break;
                }
                case 'C': {
                    result = 100;
                    break;
                }
                case 'D': {
                    result = 500;
                    break;
                }
                case 'M': {
                    result = 1000;
                    break;
                }
            }
        }

        if (args.length == 2) {
            char left = args[0];
            char right = args[1];
            checkSubStyle(left, right);
            switch(left + "" +  right) {
                case "IV": {
                    result = 5 - 1;
                    break;
                }
                case "IX": {
                    result = 10 - 1;
                    break;
                }
                case "XL": {
                    result = 50 - 10;
                    break;
                }
                case "XC": {
                    result = 100 - 10;
                    break;
                }
                case "CD": {
                    result = 500 - 100;
                    break;
                }
                case "CM": {
                    result = 1000 - 100;
                    break;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int sum = romanToInt("DCCCXCIX");
        System.out.println("转换结果是: " + sum);
    }





}
