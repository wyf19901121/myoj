package leetcode;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (T.length() == 0 || T.length() > S.length()) {
            return "";
        }
        int[] needFinds = new int[256];
        int[] hasFinds = new int[256];
        for (int i = 0; i < T.length(); i++) {
            needFinds[T.charAt(i)]++;
        }
        int minBegin = 0;
        int minEnd = S.length() - 1;
        int minLen = S.length() + 1;
        int count = 0;
        for (int begin = 0, end = 0; end < S.length(); end++) {
            char ch = S.charAt(end);
            if (needFinds[ch] == 0) {
                continue;
            }
            hasFinds[ch]++;
            if (hasFinds[ch] <= needFinds[ch]) {
                count++;
            }
            
            if (count == T.length()) {
                while (needFinds[S.charAt(begin)] < hasFinds[S.charAt(begin)]
                    || needFinds[S.charAt(begin)] == 0) {
                    if (needFinds[S.charAt(begin)] < hasFinds[S.charAt(begin)]) {
                        hasFinds[S.charAt(begin)]--;
                    }
                    begin++;
                }
                if (end - begin + 1 < minLen) {
                    minEnd = end;
                    minBegin = begin;
                    minLen = end - begin + 1;
                }
            }
        }
        return minLen == S.length() + 1 ? "" : S.substring(minBegin, minEnd+1);
    }
    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("a", "a");
    }
}
