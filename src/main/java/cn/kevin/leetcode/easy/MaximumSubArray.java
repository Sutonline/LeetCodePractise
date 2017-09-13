package cn.kevin.leetcode.easy;

/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 *
 * Personal Note:
 * Dynamic Programing could work, but i do not get it so well.
 *
 * created by yongkang.zhang
 * added at 2017/9/13
 */
public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must contain an element");
        }
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        for (int num : nums) {
            if (curMax <= 0) {
                curMax = num;
            } else {
                curMax += num;
            }
            if (max < curMax) {
                max = curMax;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.println(maxSubArray(nums));
    }
}
