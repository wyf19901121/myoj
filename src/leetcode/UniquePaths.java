package leetcode;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int [][] tempPath = new int [m][n];
        for (int i = 0; i < m; i++) {
            tempPath[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            tempPath[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tempPath[i][j] = tempPath[i-1][j] + tempPath[i][j-1];
            }
        }
        return tempPath[m-1][n-1];
    }
}
