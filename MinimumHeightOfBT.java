package com.company;

public class MinimumHeightOfBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return minHt(root);
    }

    static int minHt(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.left == null && root.right == null)
            return 1;
        int lh = minHt(root.left);
        int rh = minHt(root.right);
        return 1 + Math.min(lh, rh);
    }
}
