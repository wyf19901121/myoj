package leetcode;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	if (p == null) {
			return s == null;
		}
    	if (p.length() == 0) {
			return s.length() == 0;
		}
    	
    	char[] sch = s.toCharArray();
    	char[] pch = p.toCharArray();
    	return isMatched(sch, 0, pch, 0);
    }
    private boolean isMatched(char[] sch, int sIndex, char[] pch, int pIndex) {
    	if (pIndex == pch.length) {
			return sIndex == sch.length;
		}
    	if (pIndex + 1 < pch.length && pch[pIndex+1] == '*') {
    		while (sIndex != sch.length && (sch[sIndex] == pch[pIndex] || pch[pIndex] == '.')) {
				if (isMatched(sch, sIndex, pch, pIndex+2)) {
					return true;
				}
				sIndex++;
			}
    		return isMatched(sch, sIndex, pch, pIndex+2);
		}
    	else {
			if (sIndex != sch.length && (pch[pIndex] == '.' || pch[pIndex] == sch[sIndex])) {
				return isMatched(sch, sIndex+1, pch, pIndex+1);
			}
			return false;
		}	
	}
}
