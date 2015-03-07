package leetcode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        int [][] existMatrix = new int [board.length][board[0].length];
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res = findPath(board, existMatrix, word, i, j, 0);
                if (res) {
                    return res;
                }
            }
        }
        return res;
    }
    public boolean findPath(char[][] board, int [][] existMatrix, String word, 
            int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || existMatrix[i][j] == 1 ||
                board[i][j] != word.charAt(index)) {
            return false;
        }
        existMatrix[i][j] = 1;
        boolean res = false;
        for (int k = -1; k <= 1; k+=2) {
            res = findPath(board, existMatrix, word, i+k, j, index+1);
            if (res) {
                return res;
            }
        }
        for (int k = -1; k <= 1; k+=2) {
            res = findPath(board, existMatrix, word, i, j+k, index+1);
            if (res) {
                return res;
            }
        }
        existMatrix[i][j] = 0;
        return res;
    }
}
