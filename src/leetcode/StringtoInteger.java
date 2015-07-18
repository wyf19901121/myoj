package leetcode;

public class StringtoInteger {
	public int myAtoi(String str) {
    	if (str == null || str.length() == 0) {
			return 0;
		}
    	char[] ch = str.trim().toCharArray();
    	long value = 0;
    	int signal = 1;
    	int head = 0;
    	if (ch[0] == '-' || ch[0] == '+') {
    		signal = ch[head++] == '-' ? -1 : 1;
		}
    	while (head < ch.length && ch[head] >= '0' && ch[head] <= '9') {
    		value = value * 10 + ch[head++] - '0';
    		if (value * signal > Integer.MAX_VALUE || value * signal < Integer.MIN_VALUE) {
				return signal > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
		}
    	return (int) (value * signal);
	}
}
