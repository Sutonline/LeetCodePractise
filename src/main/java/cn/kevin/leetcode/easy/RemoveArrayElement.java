package cn.kevin.leetcode.easy;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 * created by yongkang.zhang
 * added at 2017/9/12
 */
public class RemoveArrayElement {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = 0;
        for (int num : nums) {
            if (num != val) {
                length += 1;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println("new length is : " + removeElement(new int[]{3,2,2,3}, 3));
    }
}
