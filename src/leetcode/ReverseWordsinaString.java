package leetcode;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        String res = "";
        s = s.trim();
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i-1) != ' ') {
                res = s.substring(start, i) + " " + res;
            }
            else if (s.charAt(i-1) == ' ') {
                start = i;
            }
        }
        res = s.substring(start) + " " + res;
        res = res.trim();
        return res;
    }
}
