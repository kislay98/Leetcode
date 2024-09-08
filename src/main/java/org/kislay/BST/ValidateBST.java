package org.kislay.BST;

class ValidateBST {
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

    public boolean isValidBST(TreeNode root) {
      if (root == null) {
          return true;
      }
      return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long minVal, long maxVal) {
      if (node.val < minVal || node.val > maxVal) {
          return false;
      }
      TreeNode left = node.left;
      TreeNode right = node.right;
      boolean isLeftBST = true;
      boolean isRightBST = true;
      if (left != null) {
          isLeftBST = dfs(left, minVal, (long)node.val - 1L);
      }
      if (!isLeftBST) {
          return false;
      }
      if (right != null) {
          isRightBST = dfs(right, node.val + 1L, maxVal);
      }
      return isRightBST;
    }

    public static void main(String[] args) {
      ValidateBST validateBST = new ValidateBST();
      TreeNode treeNode1 = new TreeNode(-2147483648);
      TreeNode treeNode2 = new TreeNode(-2147483648);
      treeNode1.left = treeNode2;
      validateBST.isValidBST(treeNode1);
    }


}
