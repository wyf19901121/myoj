/**
 * Created by wangyifan on 2018/1/4.
 */
public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[][] matrix = new boolean[len+1][len+1];
        matrix[len][len] = true;
        for (int i = 0; i < len; i++) {
            matrix[i][i] = true;
            matrix[i][i+1] = true;
        }
        int max = 0;
        int left = 0, right = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len-i  ; j++) {
                matrix[j][j+i+1] = matrix[j+1][j+i] && str[j] == str[j+i];
                if (matrix[j][j+i+1] && i+1 > max) {
                    max = i + 1;
                    left = j;
                    right = j + i + 1;
                }
            }
        }
        return s.substring(left, right);
    }
}
