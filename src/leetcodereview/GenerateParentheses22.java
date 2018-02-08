import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangyifan on 2018/2/8.
 */
public class GenerateParentheses22 {
    private List<String> result = new ArrayList<>();
    private Stack<Character> charStack = new Stack<>();
    private StringBuffer tempStr = new StringBuffer();

    public void generateParenthesis(int left, int right) {
        if (left == 0 && right == 0) {
            result.add(tempStr.toString());
            return;
        }
        if (left == 0) {
            charStack.pop();
            tempStr.append(')');
            generateParenthesis(left, right - 1);
            tempStr.deleteCharAt(tempStr.length() - 1);
            charStack.push('(');
        }
        else if (left <= right) {
            charStack.push('(');
            tempStr.append('(');
            generateParenthesis(left - 1, right);
            tempStr.deleteCharAt(tempStr.length() - 1);
            charStack.pop();
            if (left < right) {
                charStack.pop();
                tempStr.append(')');
                generateParenthesis(left, right - 1);
                tempStr.deleteCharAt(tempStr.length() - 1);
                charStack.push('(');
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n);
        return result;
    }

}
