package org.kislay.FillForm;

class FillForm {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rowLength = image.length;
        int colLength = image[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        dfsMatrix(image, sr, sc, color, rowLength, colLength, visited, image[sr][sc]);
        return image;
    }

    private void dfsMatrix(int[][] image, int sr, int sc, int color, int rowLength, int colLength, boolean[][] visited, int originalNum) {
        if (sr >= rowLength || sc >= colLength || sr < 0 || sc < 0 || visited[sr][sc] || image[sr][sc] != originalNum) {
            return;
        }

        visited[sr][sc] = true;
        dfsMatrix(image, sr - 1, sc, color, rowLength, colLength, visited, image[sr][sc]);
        dfsMatrix(image, sr + 1, sc, color, rowLength, colLength, visited, image[sr][sc]);
        dfsMatrix(image, sr, sc - 1, color, rowLength, colLength, visited, image[sr][sc]);
        dfsMatrix(image, sr, sc + 1, color, rowLength, colLength, visited, image[sr][sc]);
        image[sr][sc] = color;
    }

    public static void main(String[] args) {
        FillForm fillForm = new FillForm();
        int[][] image = {{0, 0, 0}, {0 , 0, 0}};
        fillForm.floodFill(image, 1, 1, 2);
    }

}
