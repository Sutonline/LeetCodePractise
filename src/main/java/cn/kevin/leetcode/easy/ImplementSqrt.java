package cn.kevin.leetcode.easy;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 * created by yongkang.zhang
 * added at 2017/9/13
 */
public class ImplementSqrt {

    public static int mySqrt(int x) {
        int remainder;
        int root;
        int multiplier = 20;
        int curNum;
        String numStr = String.valueOf(x);
        int totalLength = numStr.length();
        int y = totalLength % 2 == 0 ?  2 : 1;
        String substring = numStr.substring(0, y);
        root = getRoot(Integer.parseInt(substring));
        remainder = Integer.parseInt(substring) - (root * root);
        String tempStr;
        for (int i = y; i < totalLength - 1; i += 2) {
            if (i + 2 > totalLength - 1) {
                tempStr = numStr.substring(i);
            } else {
                tempStr = numStr.substring(i, i + 2);
            }
            curNum = remainder * 100 + Integer.parseInt(tempStr);
            int b = get2ab(curNum, root);
            remainder = curNum - (multiplier * root + b) * b;
            root = Integer.parseInt(root + "" + b);
        }

        return root;
    }


    private static int getRoot(int x) {
        int square;
        for (int i = 1; i <= 9; i++) {
            square = i * i;
            if (square == x) return i;
            if (square > x) return i - 1;
        }
        return 0;
    }

    private static int get2ab(int curRemainder, int root) {
        int multiple;
        for (int i = 1; i <= 9; i++) {
            multiple = (20 * root + i) * i;
            if (multiple == curRemainder) return i;
            if (multiple > curRemainder) return i - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("计算的平方根结果是: " + mySqrt(34125768));
    }

}
