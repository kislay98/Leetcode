package org.kislay;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int endRow = matrix.length - 1, endCol =  matrix[0].length - 1, startRow = 0, startCol = 0;
        List<Integer> res = new ArrayList<>();
        while(startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                res.add(matrix[startRow][col]);
            }
            startRow++;
            for (int row = startRow; row <= endRow; row++) {
                res.add(matrix[row][endCol]);
            }
            endCol--;
            if (startRow <= endRow) {
                for (int col = endCol; col >= startCol; col--) {
                    res.add(matrix[endRow][col]);
                }
                endRow--;
            }
            if (startCol <= endCol) {
                for (int row = endRow; row >= startRow; row--) {
                    res.add(matrix[row][startCol]);
                }
                startCol++;
            }
        }
        return res;
    }

}
