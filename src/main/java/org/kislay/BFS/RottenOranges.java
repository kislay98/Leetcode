package org.kislay.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RottenOranges {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        // q[0] = row in grid, q[1] = col in grid, q[2] = min rotting time
        Queue<int[]> queue = new LinkedList<>();
        int minutesToFullyRotten = 0;
        fillQueueWithRottenOranges(queue, grid, rowLen, colLen, visited);
        while (!queue.isEmpty()) {
            int[] rottingElement = queue.poll();
            if (rottingElement[2] > minutesToFullyRotten) {
                minutesToFullyRotten = rottingElement[2];
            }
            putValidNeighboursInQueue(queue, rottingElement, grid, rowLen, colLen, visited);
        }

        return fullyRottenTime(grid, visited, rowLen, colLen, minutesToFullyRotten);

    }

    public int fullyRottenTime(int[][] grid, boolean[][] visited, int rowLen, int colLen, int minutesToFullyRotten) {
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    return -1;
                }
            }
        }
        return minutesToFullyRotten;
    }

    private void putValidNeighboursInQueue(Queue<int[]> queue, int[] rottingElement, int[][] grid,
                                    int rowLen, int colLen, boolean[][] visited) {
        int row = rottingElement[0];
        int col = rottingElement[1];
        int rottenTime = rottingElement[2];
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen &&
                    !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                queue.add(new int[]{newRow, newCol, rottenTime + 1});
                visited[newRow][newCol] = true;
            }
        }
    }

    private void fillQueueWithRottenOranges(Queue<int[]> queue, int[][] grid, int rowLen, int colLen, boolean[][] visited) {
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r,c,0});
                    visited[r][c] = true;
                }
            }
        }
    }

}
