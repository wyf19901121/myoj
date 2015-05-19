package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordSearchII {
	class TriNode {
		TriNode[] son;
		boolean isWord;
		public TriNode() {
			// TODO Auto-generated constructor stub
			isWord = false;
			son = new TriNode[26];
		}
	}
	TriNode root = new TriNode();
	public void addWord(String word) {
		TriNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			if (cur.son[word.charAt(i) - 'a'] == null) {
				cur.son[word.charAt(i) - 'a'] = new TriNode();
			}
			cur = cur.son[word.charAt(i) - 'a'];
		}
		cur.isWord = true;
	}
	public boolean isWord(String word) {
		TriNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			if (cur.son[word.charAt(i) - 'a'] == null) {
				return false;
			}
			cur = cur.son[word.charAt(i) - 'a'];
		}
		return cur.isWord;
	}
	
	public boolean isPre(String word) {
		TriNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			if (cur.son[word.charAt(i) - 'a'] == null) {
				return false;
			}
			cur = cur.son[word.charAt(i) - 'a'];
		}
		return true;
	}
	
    public ArrayList<String> findWords(char[][] board, String[] words) {
        ArrayList<String> res = new ArrayList<String>();
        if (board.length == 0 || words.length == 0) {
			return res;
		}
        for (int i = 0; i < words.length; i++) {
			addWord(words[i]);
		}
        boolean[][] visit = new boolean [board.length][board[0].length];
        Set<String> wordSet = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				String s = "";
				s += board[i][j];
				if (isWord(s)) {
					wordSet.add(s);
				}
				if (isPre(s)) {
					dfs(s, i, j, visit, board, wordSet);
				}
			}
		}
        for (String string : wordSet) {
			res.add(string);
		}
        return res;
    }
    
    public void dfs(String src, int row, int col, boolean[][] visit, char[][] board, Set<String> wordSet) {
    	int[] dx = {1, 0, -1, 0};
    	int[] dy = {0, 1, 0, -1};
    	visit[row][col] = true;
    	for (int i = 0; i < dy.length; i++) {
			int x = row + dx[i];
			int y = col + dy[i];
			if (isValid(visit, x, y)) {
				String str = src;
				str += board[x][y];
				if (isWord(str)) {
					wordSet.add(str);
				}
				if (isPre(str)) {
					dfs(str, x, y, visit, board, wordSet);
				}
			}
		}
    	visit[row][col] = false;
	}
    
    public boolean isValid(boolean[][] visit, int row, int col) {
		if (row < 0 || row >= visit.length || col < 0 || col >= visit[0].length || visit[row][col]) {
			return false;
		}
		return true;
	}
}
