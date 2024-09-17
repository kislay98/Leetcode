package org.kislay.O1Matrix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class O1Matrix {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Map<Integer, Integer>> queue = new LinkedList<Map<Integer, Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(i, j);
                    queue.add(map);
                }
            }
        }
        if (queue.isEmpty() || queue.size() == m*n) {
            return mat;
        }
        while (!queue.isEmpty()) {
            Map<Integer, Integer> map = queue.poll();
            Map.Entry<Integer, Integer> onlyEntry = map.entrySet().stream().findFirst().get();
            Integer row = onlyEntry.getKey();
            Integer col = onlyEntry.getValue();
            updateValue(row-1, col, visited, mat, queue, mat[row][col]);
            updateValue(row+1, col, visited, mat, queue, mat[row][col]);
            updateValue(row, col-1, visited, mat, queue, mat[row][col]);
            updateValue(row, col+1, visited, mat, queue, mat[row][col]);
        }
        return mat;
    }

    private void updateValue(int row, int col, boolean[][] visited, int[][] mat, Queue<Map<Integer, Integer>> q, Integer currentValue) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length) {
            return;
        }
        if (!visited[row][col]) {
            mat[row][col] = 1 + currentValue;
            visited[row][col] = true;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(row, col);
            q.add(map);
        }
    }
}
