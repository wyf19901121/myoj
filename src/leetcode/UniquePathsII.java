package leetcode;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] tempPath = new int [obstacleGrid.length][obstacleGrid[0].length];
        tempPath[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < obstacleGrid.length; i++) {
            tempPath[i][0] = obstacleGrid[i][0] == 0 ? tempPath[i-1][0] : 0;
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            tempPath[0][i] = obstacleGrid[0][i] == 0 ? tempPath[0][i-1] : 0;
        }
        for (int i = 1 ; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    tempPath[i][j] = 0;
                }
                else {
                    tempPath[i][j] = tempPath[i-1][j] + tempPath[i][j-1];
                }
            }
        }
        return tempPath[obstacleGrid.length - 1][obstacleGrid[0].length-1];
    }
}
