package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> resStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int temp = 0;
            if ((tokens[i].charAt(0) >= '0' && tokens[i].charAt(0) <= '9') ||
                    (tokens[i].charAt(0) == '-' && tokens[i].length() > 1)) {
                resStack.push(Integer.valueOf(tokens[i]));
            }
            else if (tokens[i].equals("+")) {
                temp = resStack.pop();
                resStack.push(resStack.pop() + temp);
            }
            else if (tokens[i].equals("-")) {
                temp = resStack.pop();
                resStack.push(resStack.pop() - temp);
            }
            else if (tokens[i].equals("*")) {
                temp = resStack.pop();
                resStack.push(resStack.pop() * temp);
            }
            else if (tokens[i].equals("/")) {
                temp = resStack.pop();
                resStack.push(resStack.pop() / temp);
            }
        }
        return resStack.isEmpty() ? 0 : resStack.pop();
    }
}
