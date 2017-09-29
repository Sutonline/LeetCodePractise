package cn.kevin.leetcode.easy;

import java.util.Stack;

/**
 * symmetric tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * Personal Note:
 * Loop is harder and has another simple form with just one queue.
 * created by yongkang.zhang
 * added at 2017/9/28
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricWithRecursive(root.getLeft(), root.getRight()) ||
                isSymmetricWithLoop(root);
    }

    private static boolean isSymmetricWithRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.getVal() == right.getVal() && isSymmetricWithRecursive(left.getLeft(), right.getRight()) && isSymmetricWithRecursive(left.getRight(), right.getLeft());
    }

    private static boolean isSymmetricWithLoop(TreeNode root) {
        if (root == null) return true;
        if (root.getLeft() == null && root.getRight() == null) return true;
        if (root.getLeft() == null || root.getRight() == null) return false;
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        while (left != null || right != null) {
            if (left != null && right != null) {
                // 首先判断这两个节点是否相等
                if (left.getVal() != right.getVal()) return false;
                // 进行遍历
                if (left.getLeft() != null && right.getRight() != null) {
                    //压栈操作
                    leftStack.push(left);
                    rightStack.push(right);
                    left = left.getLeft();
                    right = right.getRight();
                } else if (left.getLeft() == null && right.getRight() == null) {
                    // 取当前节点对应的右节点和对应的左节点
                    if (left.getRight() != null && right.getLeft() != null) {
                        leftStack.push(left);
                        rightStack.push(right);
                        right = left.getRight();
                        left = right.getLeft();
                    } else if (left.getRight() == null && right.getLeft() == null) { // 出栈操作
                        left = leftStack.pop().getRight();
                        right = rightStack.pop().getLeft();
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
