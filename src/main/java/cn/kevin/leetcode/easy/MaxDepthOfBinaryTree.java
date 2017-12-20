package cn.kevin.leetcode.easy;

import java.util.Stack;

/**
 * Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * created by yongkang.zhang
 * added at 2017/9/29
 */
public class MaxDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 1;
        Stack<TreeNode> stack = new Stack<>();
        int max = 0;
        int cur = 1;
        TreeNode curNode = root;
        while (curNode != null) {
            cur += 1; //进行加1
            stack.push(curNode); // 压栈

            // 左子树遍历
            while (curNode.getLeft() != null) {
                cur += 1;
                curNode = curNode.getLeft();
            }

            if (curNode.getRight() != null) {
                cur += 1;
                curNode = curNode.getRight();
            } else {
                cur -= 1;
                curNode = stack.pop();
            }

            if (curNode.getLeft() != null) {
                curNode = curNode.getLeft();
            } else if (curNode.getRight() != null) {
                curNode = curNode.getRight();
            } else { //如果子节点不存在，那么就设置最大值并且开始向后pop
                if (cur > max) max = cur;
                curNode = stack.pop();
                cur -= 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node3.setRight(node4);
        node4.setRight(node5);
        System.out.println(maxDepth(root));
    }


}
