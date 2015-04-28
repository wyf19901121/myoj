package leetcode;

public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int[] res = new int [s.length()+1];
        boolean[][] palin = new boolean [s.length()][s.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = s.length() - i;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < palin.length; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || palin[i+1][j-1] == true)) {
                    palin[i][j] = true;
                    res[i] = Math.min(res[i], res[j+1]+1);
                }
            }
        }
        return res[0] - 1;
    }
}
