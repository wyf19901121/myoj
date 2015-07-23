package leetcode;

public class SudokuSolver {
	boolean isValid(char[][] board, int row, int col) {
		for (int i = 0; i < board.length; i++) {
			if (i != row && board[i][col] == board[row][col]) {
				return false;
			}
		}
		for (int j = 0; j < board.length; j++) {
			if (j != col && board[row][j] == board[row][col]) {
				return false;
			}
		}
		
		int r = (row / 3) * 3, c = (col / 3) * 3;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (i != row && j != col && board[i][j] == board[row][col]) {
					return false;
				}
			}	
		}
		return true;
	}	
    public void solveSudoku(char[][] board) {
    	solveSudokuSingle(board);
    }
    boolean solveSudokuSingle(char[][] board) {
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					for (int j2 = 1; j2 < 10; j2++) {
						board[i][j] = (char) ('0' + j2);
						if (isValid(board, i, j) && solveSudokuSingle(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
    	return true;
    }
}
