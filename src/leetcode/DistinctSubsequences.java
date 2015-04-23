package leetcode;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (t.length() == 0) {
            return 1;
        }
        if (s.length() == 0) {
            return 0;
        }
        int[][] res = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j <= i && j < res[0].length; j++) {
                res[i][j] = res[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    res[i][j] += res[i-1][j-1];
                }
            }
        }
        return res[s.length()][t.length()];
    }
}
