package leetcode;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) {
			return 0;
		}
        if (s.trim().length() == 0) {
			return 0;
		}
        String curString = s.trim();
        int curLen = 0;
        for (int i = curString.length() - 1; i >= 0; i--) {
			if (curString.charAt(i) == ' ') {
				return curLen;
			}
			curLen++;
		}
        return curLen;
    }
}
