package cn.kevin.leetcode.easy;

import java.util.stream.IntStream;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * Personal Note:
 * The right way is compare from right not left.
 * void merge(int A[], int m, int B[], int n) {
 * int i=m-1;
 * int j=n-1;
 * int k = m+n-1;
 * while(i >=0 && j>=0)
 * {
 * if(A[i] > B[j])
 * A[k--] = A[i--];
 * else
 * A[k--] = B[j--];
 * }
 * while(j>=0)
 * A[k--] = B[j--];
 * }
 *
 *
 *
 * created by yongkang.zhang
 * added at 2017/9/14
 */
public class MergeTwoSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = 0;
        int y = 0;
        int endIndex = m - 1;
        while (y <= n - 1) {
            if (x == endIndex) {
                if (nums1[x] > nums2[y]) {
                    shiftRight(nums1, endIndex, 1, 1);
                    nums1[x] = nums2[y];
                    y++;
                    endIndex++;
                }
            } else if (x < endIndex) {
                if (nums2[y] >= nums1[x] && nums2[y] < nums1[x + 1]) {
                    shiftRight(nums1, endIndex, x + 1, 1);
                    nums1[x + 1] = nums2[y];
                    x++;
                    y++;
                    endIndex++;
                }
            } else {
                nums1[x] = nums2[y];
                y++;
            }
            x++;
        }
        System.out.println("after merged the arrays: ");
        IntStream.range(0, m + n).forEach(i -> System.out.println(nums1[i]));
    }

    private static void shiftRight(int[] array, int elements, int from, int offset) {
        int length = array.length;
        int moveLength = elements - from + 1;
        if (from + moveLength + offset > length) {
            throw new ArrayIndexOutOfBoundsException("Cannot shift " + offset);
        }
        System.arraycopy(array, from, array, from + offset, moveLength);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 6, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 3, 5, 7, 8};
        merge(nums1, 4, nums2, 5);
    }
}
