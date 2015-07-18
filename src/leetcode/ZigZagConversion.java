package leetcode;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
    	if (s == null || s.length() == 0) {
			return s;
		}
    	if (numRows == 1) {
			return s;
		}
        StringBuilder zigZagStr = new StringBuilder(s.length());
        int modNum = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
			constructZigZagString(s, zigZagStr, i, modNum);
		}
        return zigZagStr.toString();
    }
    void constructZigZagString(String s, StringBuilder str, int row, int mod) {
    	if (s == null || s.length() == 0 || str == null || row < 0 || mod <= 0) {
			return ;
		}
    	for (int i = row; i < s.length();) {
			str.append(s.charAt(i));
//			System.out.println(row + " " + i + " " + mod);
			if (i % mod != (mod - i % mod) % mod) {
				i += i%mod>mod/2 ? 2*(mod-i%mod) : 2*(mod/2-i%mod);
			}
			else {
				i += mod;
			}
		}
    }
    public static void main(String[] args) {
		System.out.println(new ZigZagConversion().convert("ABCD", 2));
	}
}
