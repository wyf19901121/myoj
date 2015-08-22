package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char operator = input.charAt(i);
            if (operator == '+' || operator == '-' || operator == '*') {
                List<Integer> leftResult = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightResult = diffWaysToCompute(input.substring(i+1, input.length()));
                for (Integer leftInteger : leftResult) {
                    for (Integer rightInteger : rightResult) {
                        switch (operator) {
                        case '+':
                            result.add(leftInteger + rightInteger);
                            break;
                        case '-':
                            result.add(leftInteger - rightInteger);
                            break;
                        case '*':
                            result.add(leftInteger * rightInteger);
                            break;
                        default:
                            break;
                        }
                    }
                    
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}
