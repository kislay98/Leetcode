package org.kislay.LowestCommonAncestor;

class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode lowestCommonAncestorNode = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = p;
        if (p.val > q.val) {
            p = q;
            q = temp;
        }
        dfs(root, p, q);
        return lowestCommonAncestorNode;
    }

    private void dfs(TreeNode root, TreeNode small, TreeNode large) {
        if (lowestCommonAncestorNode != null) {
            return;
        }
        if (root == null) {
            return;
        }
        dfs(root.left, small, large);
        dfs(root.right, small, large);
        if (root.val >= small.val && root.val <= large.val) {
            lowestCommonAncestorNode = root;
        }
    }
}
