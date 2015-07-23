package leetcode;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (!isValidRow(board)) {
			return false;
		}
        if (!isValidCol(board)) {
			return false;
		}
        if (!isValidNine(board)) {
			return false;
		}
        return true;
    }

    private boolean isValidRow(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			int[] sign = new int [10];
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (++sign[board[i][j] - '0'] == 2) {
					return false;
				}
			}
		}
		return true;
	}

    private boolean isValidCol(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			int[] sign = new int [10];
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == '.') {
					continue;
				}
				if (++sign[board[j][i] - '0'] == 2) {
					return false;
				}
			}
		}
		return true;
	}
    
    private boolean isValidNine(char[][] board) {
		for (int i = 0; i < board.length; i+=3) {
			for (int j = 0; j < board.length; j+=3) {
				int[] sign = new int [10];
				for (int k = i; k < i+3; k++) {
					for (int k2 = j; k2 < j+3; k2++) {
						if (board[k][k2] == '.') {
							continue;
						}
						if (++sign[board[k][k2] - '0'] == 2) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
