package leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        path[0][0] = grid[0][0];
        for (int i = 1; i < path[0].length; i++) {
            path[0][i] = path[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < path.length; i++) {
            path[i][0] = path[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < path.length; i++) {
            for (int j = 1; j < path[i].length; j++) {
                path[i][j] = Math.min(path[i-1][j], path[i][j-1]) + grid[i][j];
            }
        }
        return path[path.length-1][path[0].length-1];
    }
}
