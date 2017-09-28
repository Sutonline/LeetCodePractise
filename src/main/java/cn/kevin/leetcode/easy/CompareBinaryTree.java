package cn.kevin.leetcode.easy;

import java.util.Objects;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 *
 * note:
 * This divided into two ways: recursive and loop with stack.
 * Code following is not right, because the object changes after checkLeft.
 *
 * <p>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * created by yongkang.zhang
 * added at 2017/9/15
 */
public class CompareBinaryTree {

    public static boolean isSameTree(TreeNode left, TreeNode right) {
        return checkLeft(left, right) && checkRight(left, right);
    }

    private static boolean checkLeft(TreeNode left, TreeNode right) {
        while (left != null || right != null) {
            if (left == null || right == null) return false;
            if (! Objects.equals(left.getVal(), right.getVal())) {
                return false;
            }
            left = left.getLeft();
            right = right.getRight();
        }
        return true;
    }

    private static boolean checkRight(TreeNode left, TreeNode right) {
        while (left != null || right != null) {
            if (left == null || right == null) return false;
            if (!Objects.equals(left.getVal(), right.getVal())) {
                return false;
            }
            left = left.getRight();
            right = right.getRight();
        }
        return true;
    }

    public static void main(String[] args) {

    }

}


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}