package LeetCode.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    // FASTER
    public int solutionQ200(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                    result += 1;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }

    // SLOWER
    public int solutionBfsQ200(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int r = curr[0];
                        int c = curr[1];
                        if (r + 1 < grid.length && grid[r+1][c] == '1') {
                            grid[r + 1][c] = '0';
                            queue.add(new int[]{r + 1, c});
                        }
                        if (r - 1 >= 0 && grid[r-1][c] == '1') {
                            grid[r - 1][c] = '0';
                            queue.add(new int[]{r - 1, c});
                        }
                        if (c + 1 < grid[0].length && grid[r][c+1] == '1') {
                            grid[r][c + 1] = '0';
                            queue.add(new int[]{r, c + 1});
                        }
                        if (c - 1 >= 0 && grid[r][c-1] == '1') {
                            grid[r][c - 1] = '0';
                            queue.add(new int[]{r, c - 1});
                        }
                    }
                    result += 1;
                }
            }
        }
        return result;
    }
}
