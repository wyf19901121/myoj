package leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	if (s == null || s.length() == 0) {
			return s;
		}
    	StringBuilder newStrBuilder = new StringBuilder(2 * s.length() + 3);
    	newStrBuilder.append('@');
    	for (int i = 0; i < 2*s.length()+1; i++) {
    		if ((i & 0x1) == 1) {
    			newStrBuilder.append(s.charAt(i/2));
			}
    		else {
				newStrBuilder.append('#');
			}
		}
    	newStrBuilder.append('$');
    	int[] len = new int [2 * s.length() + 3];
    	len[0] = 1;
    	String newStr = newStrBuilder.toString();
    	int maxLen = 0, rightPos = 0, midPos = 0, maxIndex = 0;
//    	System.out.println(newStr);
    	for (int i = 1; i < len.length - 1; i++) {
//    		System.out.println("i = " + i);
    		if (rightPos > i) {
				len[i] = Math.min(rightPos - i, len[2*midPos-i]);
			}
    		else {
				len[i] = 1;
			}
    		while (newStr.charAt(i + len[i]) == newStr.charAt(i - len[i])) {
				len[i]++;
			}
    		if (len[i] + i > rightPos) {
				rightPos = i + len[i];
				midPos = i;
			}
    		if (len[i] > maxLen) {
				maxLen = len[i];
				maxIndex = i;
			}
    	}
    	System.out.println("maxIndex = " + maxIndex + "; maxLen = " + maxLen);
    	StringBuilder reString = new StringBuilder(maxLen);
    	for (int i = maxIndex - maxLen + 1; i < maxIndex + maxLen; i++) {
			if (newStr.charAt(i) != '#') {
				reString.append(newStr.charAt(i));
			}
		}
    	return reString.toString();
    }
    
    public static void main (String[] arg) {
    	System.out.println(new LongestPalindromicSubstring().longestPalindrome("baba"));
    }
}
