package leetcode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> resStack = new Stack<>();
        if (path.length() == 0 || path.charAt(0) != '/') {
            return "";
        }
        int head = 0, tail = 1;
        while (tail < path.length()) {
            while (head < path.length() && path.charAt(head) == '/') {
                head++;
            }
            if (head == path.length()) {
                break;
            }
            tail = path.indexOf('/', head);
            tail = tail < 0 ? path.length() : tail;
            String cur = path.substring(head, tail);
            if (cur.equals("..")) {
                if (!resStack.isEmpty()) {
                    resStack.pop();
                }
            }
            else if (!cur.equals(".")) {
                resStack.push("/" + cur);
            }
            head = tail;
        }
        if (resStack.isEmpty()) {
            return "/";
        }
        String resString = "";
        while (!resStack.isEmpty()) {
            resString = resStack.pop() + resString;
        }
        return resString;
    }
}
