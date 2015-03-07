package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
    	if (board.length == 0) {
    		return;
    	}
    	int m = board.length;
    	int n = board[0].length;
    	for (int i = 0; i < n; i++) {
    		if (board[0][i] == 'O') {
        		bfs(board, 0, i);   			
    		}
    		if (board[m-1][i] == 'O') {
        		bfs(board, m-1, i);    			
    		}
    	}
    	for (int i = 1; i < m - 1; i++) {
    		if (board[i][0] == 'O') {
    			bfs(board, i, 0);
    		}
    		if (board[i][n-1] == 'O') {
    			bfs(board, i, n-1);
    		}
    	}
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (board[i][j] == 'O') {
    				board[i][j] = 'X';
    			}
    			if (board[i][j] == 'E') {
    				board[i][j] = 'O';
    			}
    		}
    	}
    }
    public void bfs(char[][] board, int row, int col) {
    	int m = board.length;
    	int n = board[0].length;
    	Queue<Integer> R = new LinkedList<Integer> ();
    	Queue<Integer> C = new LinkedList<Integer> ();
    	board[row][col] = 'E';
    	R.offer(row);
    	C.offer(col);
    	int r = 0, c = 0;
    	while (R.size() != 0) {
    		r = R.poll();
    		c = C.poll();
    		if (r != 0 && board[r-1][c] == 'O') {
    			R.offer(r-1);
    			C.offer(c);
    			board[r-1][c] = 'E';
    		}
    		if (r != m - 1 && board[r+1][c] == 'O') {
    			R.offer(r+1);
    			C.offer(c);
    			board[r+1][c] = 'E';
    		}
    		if (c != 0 && board[r][c-1] == 'O') {
    			R.offer(r);
    			C.offer(c-1);
    			board[r][c-1] = 'E';
    		}
    		if (c != n - 1 && board[r][c+1] == 'O') {
    			R.offer(r);
    			C.offer(c+1);
    			board[r][c+1] = 'E';
    		}
    	}
    }
}
