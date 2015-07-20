package leetcode;

public class RomantoInteger {
	
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
        	return 0;
        }
        int value = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
			char curLetter = s.charAt(i);
			int cur = 0;
			switch (curLetter) {
			case 'M':
				cur = 1000;
				break;
			case 'D':
				cur = 500;
				break;
			case 'C':
				cur = 100;
				break;
			case 'L':
				cur = 50;
				break;
			case 'X':
				cur = 10;
				break;
			case 'V':
				cur = 5;
				break;
			case 'I':
				cur = 1;
				break;
			default:
				return 0;
			}
			if (cur > last) {
				value += -last;
			}
			else {
				value += last;
			}
			last = cur;
		}
        value += last;
        return value;
    }
}
