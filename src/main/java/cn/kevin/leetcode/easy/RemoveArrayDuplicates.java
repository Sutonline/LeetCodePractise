package cn.kevin.leetcode.easy;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * created by yongkang.zhang
 * added at 2017/9/12
 */
public class RemoveArrayDuplicates {

    /**
     * because it's sorted, so just keep last value to compare with current
     * @param nums 整型数组
     * @return 新数组的长度
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        int last = nums[0];
        int newLength = 0;
        for (int num : nums) {
            if (last != num) {
                last = num;
                newLength += 1;
            }
        }

        return newLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 5, 5, 6};
        System.out.println("新长度是: " + removeDuplicates(nums));
    }
}
