package leetcode;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String result = "";
        if (s.length() == 0) {
			return "";
		}
        String r = s + new StringBuilder(s).reverse().toString();
        int[] next = new int [s.length() * 2 + 1];
        next[0] = next[1] = 0;
        for (int i = 1; i < next.length - 1; i++) {
			int j = next[i];
			while (r.charAt(i) != r.charAt(j) && j > 0) {
				j = next[j];
			}
			if (r.charAt(i) == r.charAt(j)) {
				next[i + 1] = j + 1;
			}
			else {
				next[i + 1] = 0;
			}
		}
        int count = s.length() - next[next.length - 1];
        result = new StringBuilder(s.substring(s.length()-count, s.length())).reverse().toString() + s;
        return result;
    }
}
