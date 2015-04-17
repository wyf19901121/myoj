package leetcode;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        boolean[][][] scremable = new boolean[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                scremable[0][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                for (int j2 = 0; j2 < len - i; j2++) {
                    for (int k = 0; k < i && scremable[i][j][j2] == false; k++) {
                        scremable[i][j][j2] = (scremable[k][j][j2] && scremable[i-k-1][j+k+1][j2+k+1])
                                || (scremable[k][j][j2+i-k] && scremable[i-k-1][j+k+1][j2]);
                    }
                }
            }
        }
        return scremable[len-1][0][0];
    }
}
