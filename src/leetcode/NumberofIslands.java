package leetcode;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    test(grid, i+1, j);
                    test(grid, i, j+1);
                    test(grid, i-1, j);
                    test(grid, i, j-1);
                    sum++;
                }
                grid[i][j] = '2';
            }
        }
        return sum;
    }
    public void test(char[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
            return;
        }
        if (grid[row][col] != '1') {
            grid[row][col] = '2';
        }
        else {
            grid[row][col] = '2';
            test(grid, row+1, col);
            test(grid, row, col+1);
            test(grid, row-1, col);
            test(grid, row, col-1);
        }
        return;
    }
}
