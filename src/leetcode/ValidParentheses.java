package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
			return true;
		}
        char[] sch = s.toCharArray();
        Stack<Character> parenttheses = new Stack<Character>();
        for (int i = 0; i < sch.length; i++) {
			switch (sch[i]) {
			case '(':
			case '[':
			case '{':
				parenttheses.push(sch[i]);
				break;
			case ')':
			case ']':
			case '}':
				if (parenttheses.isEmpty()) {
					return false;
				}
				char lastParetnthese = parenttheses.pop();
				if (lastParetnthese == '(' && sch[i] == ')'
					|| lastParetnthese == '[' && sch[i] == ']'
					|| lastParetnthese == '{' && sch[i] == '}') {
				}
				else {
					return false;
				}
				break;
			default:
				return false;
			}
		}
        return parenttheses.isEmpty();
    }
}
