package org.kislay.DFS;

import java.util.ArrayList;

class DFS {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        dfsOfI(visited, 0, adj, result);
        return result;
    }

    void dfsOfI(boolean[] visited, Integer currIndex, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result) {
        visited[currIndex] = true;
        result.add(currIndex);
        adj.get(currIndex).forEach(i -> {
            if (!visited[i]) {
                dfsOfI(visited, i, adj, result);
            }
        });
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> inx0 = new ArrayList<>(){};
        inx0.add(2);
        inx0.add(3);
        inx0.add(1);
        ArrayList<Integer> inx1 = new ArrayList<>();
        inx1.add(0);
        ArrayList<Integer> inx2 = new ArrayList<>();
        inx2.add(0);
        inx2.add(4);
        ArrayList<Integer> inx3 = new ArrayList<>();
        inx3.add(0);
        ArrayList<Integer> inx4 = new ArrayList<>();
        inx4.add(2);
        DFS DFS = new DFS();
        adj.add(inx0);
        adj.add(inx1);
        adj.add(inx2);
        adj.add(inx3);
        adj.add(inx4);
        System.out.println(DFS.dfsOfGraph(5, adj));
    }
}