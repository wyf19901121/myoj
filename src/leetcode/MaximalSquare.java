package leetcode;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length + 1];
        int max = 0, pre = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                int temp = dp[j];
                if (matrix[i][j-1] == '1') {
                    dp[j] = Math.min(pre, Math.min(dp[j-1], dp[j])) + 1;
                    max = Math.max(max, dp[j]);
                }
                else {
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return max * max;
    }
}
