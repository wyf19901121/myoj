package leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
    	int lenA = a.length();
    	int lenB = b.length();
    	char[] longStr = lenA >= lenB ? a.toCharArray() : b.toCharArray();
    	char[] shortStr = lenA >= lenB ? b.toCharArray() : a.toCharArray();
    	int longLen = Math.max(lenA, lenB);
    	int shortLen = Math.min(lenA, lenB);
    	char[] sum = new char[longLen];
    	int last = 0;
    	for (int i = longLen - 1, j = shortLen - 1; i >= 0 ; i--, j--) {
    		int cur = 0;
			if (j < 0) {
				cur = longStr[i] - '0' + last;
			}
			else {
				cur = longStr[i] - '0' + shortStr[j] - '0' + last;
			}
			sum[i] = (char) (cur % 2 + '0');
			last = cur / 2;
		}
    	String str = new String(sum);
    	if (last != 0) {
			str = '1' + str;
		}
    	return str;
    }
}
