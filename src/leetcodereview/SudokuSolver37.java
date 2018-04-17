/**
 * Created by wangyifan on 2018/4/17.
 */
public class SudokuSolver37 {
    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length ; i++) {
            if (i != row && board[row][col] == board[i][col]) {
                return false;
            }
        }

        for (int j = 0; j < board.length; j++) {
            if (j != col && board[row][col] == board[row][j]) {
                    return false;
            }
        }

        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (i != row && j != col && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean solveSudokuSingle(char[][] board) {
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; k++) {
                        board[i][j] = (char)('1' + k);
                        if (isValid(board, i, j) && solveSudokuSingle(board)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuSingle(board);
    }
}
