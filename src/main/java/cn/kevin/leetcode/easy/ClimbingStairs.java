package cn.kevin.leetcode.easy;

import java.math.BigDecimal;
import java.util.stream.IntStream;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 * created by yongkang.zhang
 * added at 2017/9/14
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        switch (n) {
            case 0 :
                return 0;
            case 1 :
                return 1;
            case 2 :
                return 2;
            default:
                return climbStairs(n - 1) + climbStairs(n -2);
        }
    }


    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        IntStream.range(1, 22).forEach(i ->
            System.out.println(i + " result: total " + climbStairs(i) + " way."));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        long t3 = System.currentTimeMillis();
        IntStream.range(1, 44).forEach(i ->
                System.out.println(i + " result: total " + getByCombination(i) + " way."));
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
    }



    /** 使用组合的方式进行计算 **/
    public static BigDecimal combination(BigDecimal a, BigDecimal b) {
        return getFactorialSum(a).divide(getFactorialSum(b).multiply(getFactorialSum(a.subtract(b))));
    }

    private static BigDecimal getFactorialSum(BigDecimal n) {
        if (n.compareTo(BigDecimal.ONE) == 0 || n.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        } else {
            return getFactorialSum(n.subtract(BigDecimal.ONE)).multiply(n);
        }
    }
    private static long fib(int n) {
        return n<2?1:(fib(n-1)+fib(n-2));
    }

    public static int getByCombination(int in) {
        BigDecimal rs = BigDecimal.ONE;
        try {
            if(in==0){
                rs = BigDecimal.ZERO;
            }else{
                for (int i = 1; i <= in / 2; i++) {
                    rs = rs.add(combination(new BigDecimal(in - i), new BigDecimal(i)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs.intValue();
    }

}
