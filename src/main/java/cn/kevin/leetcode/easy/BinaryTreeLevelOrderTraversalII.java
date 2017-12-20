package cn.kevin.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 *  9  20
 *    /  \
 *   15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * created by yongkang.zhang
 * added at 2017/12/14
 */
public class BinaryTreeLevelOrderTraversalII {

    private static Map<Integer, List<Integer>> map = new HashMap<>();

    /**
     * 采用后续遍历
     * @param node
     */
    public static void traverse(TreeNode node, int level) {
        if (node == null)
            return;

        add(map, level, node.val);
        traverse((node.getLeft()), level + 1);
        traverse(node.getRight(), level + 1);
    }

    private static void add(Map<Integer, List<Integer>> map, int level, int val) {
        List<Integer> integers = map.computeIfAbsent(level, k -> new ArrayList<>());
        integers.add(val);
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);
        return root;
    }

    public static void main(String[] args) {
        traverse(getTree(), 1);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach((entry) -> System.out.println(entry.getValue()));

    }


    private static class TreeNode {
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
}

