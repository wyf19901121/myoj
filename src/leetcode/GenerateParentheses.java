package leetcode;

import java.util.ArrayList;

public class GenerateParentheses {
    public ArrayList<String> reStrings = new ArrayList<>();
    public ArrayList<String> generateParenthesis(int n) {
        char[] tempStr = new char[2*n];
        getRes(tempStr, n, n);
        return reStrings;
    }
    public void getRes(char[] temp, int left, int right) {
        if (right == 0) {
            reStrings.add(String.copyValueOf(temp));
            return;
        }
        if (left == 0) {
            temp[temp.length - left - right] = ')';
            getRes(temp, left, right - 1);
        }
        else if (left < right) {
            temp[temp.length - left - right] = '(';
            getRes(temp, left - 1, right);
            temp[temp.length - left - right] = ')';
            getRes(temp, left, right - 1);
        }
        else {
            temp[temp.length - left - right] = '(';
            getRes(temp, left - 1, right);
        }
    }
}
