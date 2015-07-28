package leetcode;

public class CountandSay {
    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder(20);
        str.append("1");
        for (int i = 2; i <= n; i++) {
			str = countAndSay(str);
		}
        return str.toString();
    }
    
    public StringBuilder countAndSay(StringBuilder str) {
		StringBuilder newStr = new StringBuilder(20);
		for (int i = 0; i < str.length();) {
			int j = i + 1;
			while (j <= str.length()) {
				if (j == str.length() || str.charAt(i) != str.charAt(j)) {
					newStr.append(String.valueOf(j - i));
					newStr.append(str.charAt(i));
					i = j;
					break;
				}
				j++;
			}
		}
		return newStr;
	}
}
