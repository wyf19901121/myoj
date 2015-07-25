package leetcode;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
    	if (s == null || s.length() == 0) {
			return 0;
		}
    	Stack<Integer> numStack = new Stack<Integer>();
    	int res = 0;
    	int sign = 1;
    	for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int cur = ch - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = 10 * cur + s.charAt(++i) - '0';
				}
				res += sign * cur;
			}
			else if (ch == '+') {
				sign = 1;
			}
			else if (ch == '-') {
				sign = -1;
			}
			else if (ch == '(') {
				numStack.push(res);
				res = 0;
				numStack.push(sign);
				sign = 1;
			}
			else if (ch == ')') {
				res = res * numStack.pop() + numStack.pop();
				sign = 1;
			}
		}
    	return res;
    }
    
    public static void main(String[] args) {
		System.out.println(new BasicCalculator().calculate("2147483647"));
	}
}
