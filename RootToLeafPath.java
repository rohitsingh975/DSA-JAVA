package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RootToLeafPath {
    List<String> result = new ArrayList<>();

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

    public List<String> binaryTreePaths(TreeNode root) {
        printPaths(root, new ArrayList<>());
        return result;
    }

    public void printPaths(TreeNode root, List<String> pathTillNow) {
        if (root == null)
            return;
        pathTillNow.add(root.val + "");
        if (root.left == null && root.right == null)
            result.add(pathTillNow.stream().collect(Collectors.joining("->")));
        printPaths(root.left, pathTillNow);
        printPaths(root.right, pathTillNow);
        pathTillNow.remove(pathTillNow.size() - 1);
    }
}
