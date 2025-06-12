import LeetCode.arrays.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
//        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(solution.solutionBfsQ200(grid));

    }

}