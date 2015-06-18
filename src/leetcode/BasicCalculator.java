package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> operator = new Stack<>();
        ArrayList<Integer> post = new ArrayList<>();
        int index = 0;
        while (index != s.length()) {
            char ch = s.charAt(index);
            switch (ch) {
            case ' ':
                index++;
                break;
            case '(':
                operator.push((int) '(');
                index++;
                break;
            case ')':
                while (!operator.empty() && operator.peek() != '(') {
                    post.add(operator.pop());
                }
                operator.pop();
                index++;
                break;
            case '+':
            case '-':
                while (!operator.empty() && operator.peek() != '(') {
                    post.add(operator.pop());
                }
                operator.push((int) ch);
                index++;
                break;
            default:
                int val = 0;
                while (index < s.length() && s.charAt(index) > '0' && s.charAt(index) < '9') {
                    val = 10 * val + s.charAt(index) - '0';
                    index++;
                }
                post.add(-val);
                break;
            }
        }
        while (!operator.empty()) {
            post.add(operator.pop());
        }
        operator.clear();
        for (int i = 0; i < post.size(); i++) {
            int ch = post.indexOf(i);
            int left, right;
            switch (ch) {
            case '+':
                right = operator.pop();
                left = operator.pop();
                operator.push(left + right);
                break;
            case '-':
                right = operator.pop();
                left = operator.pop();
                operator.push(left - right);
                break;
            default:
                operator.push(ch);
                break;
            }
        }
        return operator.pop();
    }
}
