package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        boolean[] match = new boolean[s.length()];
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < match.length; i++) {
            if (s.charAt(i) == '(') {
                index.push(i);
            }
            else if (!index.empty()) {
                match[i] = true;
                match[index.pop()] = true;
            }
        }
        int maxlen = 0, curlen = 0;
        for (int i = 0; i < match.length; i++) {
            if (match[i]) {
                curlen++;
            }
            else {
                curlen = 0;
            }
            maxlen = Math.max(maxlen, curlen);
        }
        return maxlen;
    }
}
