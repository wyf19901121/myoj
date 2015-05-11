package leetcode;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
			return s.length() == 0;
		}
        char[] src = s.toCharArray();
        char[] pos = p.toCharArray();
        return isMatchsub(src, 0, pos, 0);
    }
    public boolean isMatchsub(char[] s, int sindex, char[] p, int pindex) {
		if (pindex == p.length) {
			return sindex == s.length;
		}
		if (pindex+1 < p.length && p[pindex+1] == '*') {
			while (sindex!= s.length && (s[sindex] == p[pindex] || p[pindex] == '.')) {
				if (isMatchsub(s, sindex, p, pindex + 2)) {
					return true;
				}
				sindex++;
			}
			return isMatchsub(s, sindex, p, pindex+2);
		}
		else {
			if (sindex != s.length && (s[sindex] == p[pindex] || p[pindex] == '.')) {
				return isMatchsub(s, sindex+1, p, pindex+1);
			}
			return false;
		}
	}
}
