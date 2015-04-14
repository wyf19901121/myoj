package leetcode;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (T.length() == 0 || T.length() > S.length()) {
            return "";
        }
        int[] needFind = new int [256];
        int[] hasFind = new int [256];
        for (int i = 0; i < T.length(); i++) {
            needFind[T.charAt(i)]++;
        }
        int minBegin = 0;
        int minEnd = S.length() - 1;
        int minWindows = S.length() + 1;
        int count = 0;
        for (int end = 0, begin = 0; end < S.length(); end++) {
            char ch = S.charAt(end);
            if (needFind[ch] == 0) {
                continue;
            }
            hasFind[ch]++;
            if (hasFind[ch] <= needFind[ch]) {
                count++;
            }
            if (count == T.length()) {
                while (needFind[S.charAt(begin)] == 0 || hasFind[S.charAt(begin)] > needFind[S.charAt(begin)]) {
                    if (hasFind[S.charAt(begin)] > needFind[S.charAt(begin)]) {
                        hasFind[S.charAt(begin)]--;
                    }
                    begin++;
                }
                if (end - begin + 1 < minWindows) {
                    minWindows = end - begin + 1;
                    minBegin = begin;
                    minEnd = end;
                }
            }
        }
        return minWindows == S.length() + 1 ? "" : S.substring(minBegin, minEnd+1);
    }
}
