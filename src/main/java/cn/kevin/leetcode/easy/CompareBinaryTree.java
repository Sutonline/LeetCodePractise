package cn.kevin.leetcode.easy;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <p>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * created by yongkang.zhang
 * added at 2017/9/15
 */
public class CompareBinaryTree {

    public boolean isSameTree(TreeNode left, TreeNode right) {

        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}