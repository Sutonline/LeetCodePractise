package cn.kevin.leetcode.easy;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * created by yongkang.zhang
 * added at 2017/9/8
 */
public class TwoSum {

    private static int[] twoSum(int[] array, int target) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Null array found !");
        }
        if (array.length == 1 && array[0] == target) {
            return new int[]{-1, 0};
        }

        for (int x = 0; x <= array.length; x++) {
            for (int y = x + 1; y < array.length; y++) {
                if (array[x] + array[y] == target) {
                    System.out.println("found two indexes are: " + x + ", " + y);
                    return new int[]{x, y};
                }
            }
        }

        throw new RuntimeException("Can't found two element added up to target");
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        twoSum(array, 10);
    }
}
