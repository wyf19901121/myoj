package leetcode;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] res = new boolean [len1 + 1][len2 + 1];
        res[0][0] = true;
        for (int i = 1; i < res.length; i++) {
            res[i][0] = res[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int j = 1; j < res[0].length; j++) {
            res[0][j] = res[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                res[i][j] = res[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1))
                        || res[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return res[len1][len2];
    }
}
