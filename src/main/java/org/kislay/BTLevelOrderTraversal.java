package org.kislay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BTLevelOrderTraversal {


    public static class TreeNode {
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

    class LeveledTreeNode {
        public TreeNode node;
        public int level;

        public LeveledTreeNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<LeveledTreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(new LeveledTreeNode(root, level));
        Map<Integer, List<Integer>> orderedLevelMap = new HashMap<>();
        while (!q.isEmpty()) {
            LeveledTreeNode leveledTreeNode = q.poll();
            if (orderedLevelMap.containsKey(leveledTreeNode.level)) {
                orderedLevelMap.get(leveledTreeNode.level).add(leveledTreeNode.node.val);
            } else {
                List<Integer> objects = new ArrayList<>();
                objects.add(leveledTreeNode.node.val);
                orderedLevelMap.put(leveledTreeNode.level, objects);
            }
            if (leveledTreeNode.node.left != null) q.add(new LeveledTreeNode(leveledTreeNode.node.left, leveledTreeNode.level+1));
            if (leveledTreeNode.node.right != null) q.add(new LeveledTreeNode(leveledTreeNode.node.right, leveledTreeNode.level+1));
        }
        List<List<Integer>> orderedLevelLists = new ArrayList<>();
        orderedLevelMap.forEach((key, value) -> orderedLevelLists.add(value));
        return orderedLevelLists;
    }

    public static void main(String[] args) {
        BTLevelOrderTraversal btLevelOrderTraversal = new BTLevelOrderTraversal();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        btLevelOrderTraversal.levelOrder(node3);
    }
}
