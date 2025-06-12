package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> solutionQ54(int[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;
        int numOfElements = row * column;
        List<Integer> result = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = row - 1;
        int columnStart = 0;
        int columnEnd = column - 1;

        while (true) {
            // add first row
            for (int c = columnStart; c <= columnEnd; c++) {
                result.add(matrix[rowStart][c]);
            }
            rowStart++;
            if (result.size() == numOfElements) break;

            // add last column
            for (int r = rowStart; r <= rowEnd; r++) {
                result.add(matrix[r][columnEnd]);
            }
            columnEnd--;
            if (result.size() == numOfElements) break;

            // add last row in reverse
            for (int c = columnEnd; c >= columnStart; c--) {
                result.add(matrix[rowEnd][c]);
            }
            rowEnd--;
            if (result.size() == numOfElements) break;

            // add first column in reverse
            for (int r = rowEnd; r >= rowStart; r--) {
                result.add(matrix[r][columnStart]);
            }
            columnStart++;
            if (result.size() == numOfElements) break;
        }

        return result;
    }
}
