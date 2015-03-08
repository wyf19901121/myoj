package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] num) {
    	int n = num.length;
    	String[] strs = new String[n];
    	
    	for (int i = 0; i < n; i++) {
			strs[i] = String.valueOf(num[i]);
		}
    	Arrays.sort(strs, new CMP());
    	
    	String s = "";
    	for (int i = n - 1; i >= 0; i--) {
			s = s.concat(strs[i]);
		}
    	
    	int i = 0;
    	while (i < n && s.charAt(i) == '0') {
			i++;
		}
    	
    	return i == n ? "0" : s.substring(i);
    }
}

class CMP implements Comparator<String> {
	public int compare(String a, String b) {
		String ab = a.concat(b);
		String ba = b.concat(a);
		return (int) (Long.parseLong(ab) - Long.parseLong(ba));
	}
}
