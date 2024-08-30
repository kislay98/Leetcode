package org.kislay;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int globalMaxDiameter = 0;


    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Boolean> visited = new HashMap<>();
        if (root == null) {
            return 0;
        }
        depth(visited, root);
        return globalMaxDiameter;
    }

    public int depth(Map<TreeNode, Boolean> visited, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int depthLeft = depth(visited, node.left);
        int depthRight = depth(visited, node.right);
        int maxCurrDepth = 1 + Math.max(depthLeft, depthRight);
        int currentDiameter = depthLeft + depthRight;
        globalMaxDiameter = Math.max(globalMaxDiameter, currentDiameter);
        return maxCurrDepth;
    }




    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.globalMaxDiameter);

    }

}
