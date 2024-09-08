package org.kislay.HeightBalancedBinaryTree;


class HeightBalancedBinaryTree {

    class TreeNode {
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

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode node) {
        if (!isBalanced) {
            return 0;
        }
        if (node == null) {
            return 0;
        }
        int leftHeight = 1 + dfs(node.left);
        int rightHeight = 1 + dfs(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }
        return Math.max(leftHeight, rightHeight);
    }
}
