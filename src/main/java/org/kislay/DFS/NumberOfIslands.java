package org.kislay.DFS;

class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        int count = 0;
        for(int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    dfs(grid, visited, r, c, rowLength, colLength);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col, int rowLength, int colLength) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row + 1, col, rowLength, colLength);
        dfs(grid, visited, row, col + 1, rowLength, colLength);
        dfs(grid, visited, row - 1, col, rowLength, colLength);
        dfs(grid, visited, row, col - 1, rowLength, colLength);
    }
}
