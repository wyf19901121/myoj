import java.util.Arrays;

/**
 * Created by wangyifan on 2018/4/11.
 */
public class ValidSudoku {
    private boolean isValid(boolean[] visited, char ch) {
        if (ch == '.') {
            return true;
        }

        int index = ch - '0';
        if (index < 1 || index > 9 || visited[index - 1]) {
            return false;
        }
        visited[index - 1] = true;
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[j][i])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        if (!isValid(visited, board[i + k][j + m])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
