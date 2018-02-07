import java.util.Stack;

/**
 * Created by wangyifan on 2018/2/5.
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        char[] ch = s.toCharArray();
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
            case '(':
            case '[':
            case '{':
                charStack.push(ch[i]);
                break;
            case ')':
            case ']':
            case '}':
                if (charStack.empty()) {
                    return false;
                }
                char topChar = charStack.pop();
                if (topChar == '(' && ch[i] == ')'
                        || topChar == '[' && ch[i] == ']'
                        || topChar == '{' && ch[i] == '}') {
                }
                else {
                    return false;
                }
            }
        }
        return charStack.empty();
    }
}
