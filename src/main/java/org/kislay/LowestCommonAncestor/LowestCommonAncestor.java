package org.kislay.LowestCommonAncestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class LowestCommonAncestor {

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null || root == p || root == q)
             return null;
        List<Integer> pathp = new ArrayList<>();
        List<Integer> pathq = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>(),pathp, pathq);
        int i = 0;
        Integer lowestCommonAncestor = null;
        for (; i < Math.min(pathp.size(), pathq.size()); i++) {
            Integer pPathNode = pathp.get(i);
            Integer qPathNode = pathq.get(i);
            if (!Objects.equals(pPathNode, qPathNode)) {
                lowestCommonAncestor = pathp.get(i - 1);
                break;
            }
        }
        TreeNode tnValue = null;
        return tnValue;
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> currPath, List<Integer> pathp, List<Integer> pathq) {
         if (node == null) {
             return;
         }
         currPath.add(node);
        if (node == p) {
            pathp = insertPath(currPath);
        }
        if (node == q) {
            pathq = insertPath(currPath);
        }
         dfs(node.left, p,q,currPath, pathp, pathq);
         dfs(node.right, p,q, currPath, pathp, pathq);
         currPath.remove(node);
    }

    List<Integer> insertPath(List<TreeNode> currPath) {
        List<Integer> path = new ArrayList<>();
        for (TreeNode treeNode : currPath) {
            path.add(treeNode.val);
        }
         return path;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode5;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        treeNode3.right = treeNode1;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        lowestCommonAncestor.lowestCommonAncestor(treeNode3, treeNode5, treeNode1);
    }

}
