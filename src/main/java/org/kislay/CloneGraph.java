package org.kislay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        map.put(node, new Node(node.val));
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                // all neighbour ka map mei new node ke saath hona chahiye
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public Node cloneGraph2(Node node) {
        Map<Integer, Node> vis = new HashMap<Integer, Node> ();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty()) {
            Node temp = q.poll();
            if(!vis.containsKey(temp.val))
                vis.put(temp.val, new Node(temp.val));
            for(int i=0; i<temp.neighbors.size(); ++i) {
                if(vis.containsKey(temp.neighbors.get(i).val)) {
                    vis.get(temp.val).neighbors.add(vis.get(temp.neighbors.get(i).val));
                } else {
                    Node tt = new Node(temp.neighbors.get(i).val);
                    q.add(temp.neighbors.get(i));
                    vis.put(tt.val, tt);
                    vis.get(temp.val).neighbors.add(tt);
                }
            }
        }
        return vis.get(node.val);
    }


    public static void main(String[] args) {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph graph = new CloneGraph();
        System.out.println(graph.cloneGraph2(node1).equals(graph.cloneGraph(node1)));
    }



}
