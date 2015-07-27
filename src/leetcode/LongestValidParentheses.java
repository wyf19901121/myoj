package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	boolean[] match = new boolean[s.length()];
    	Stack<Integer> indexs = new Stack<Integer>();
    	for (int i = 0; i < match.length; i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				indexs.push(i);
			}
			else if (!indexs.isEmpty()) {
				match[i] = true;
				match[indexs.pop()] = true;
			}
		}
    	int len = 0, max = 0;
    	for (int i = 0; i < match.length; i++) {
			if (match[i] == true) {
				len++;
			}
			else {
				len = 0;
			}
			max = Math.max(len, max);
		}
    	return max;
    }
}
