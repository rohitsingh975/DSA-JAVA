package com.company;

public class BinaryTreeDiameter {
    int ans = 0;

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

    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        if (root == null)
            return 0;
        getHT(root, diameter);
        return diameter[0];
    }

    public int getHT(TreeNode root, int[] diameter) {
        if (root == null)
            return 0;
        int lh = getHT(root.left, diameter);
        int rh = getHT(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
