package leetcode;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
    	if (haystack == null || needle == null) {
			return -1;
		}
    	if (needle.isEmpty()) {
			return 0;
		}
    	if (haystack.isEmpty()) {
			return -1;
		}
        char[] src = haystack.toCharArray();
        char[] dest = needle.toCharArray();
        int[] next = new int[needle.length()];
        next[0] = -1;
        if (next.length > 1) {
			next[1] = 0;
		}
        for (int i = 2; i < next.length; i++) {
			int j = next[i - 1];
			while (j != -1 && dest[i - 1] != dest[j]) {
				j = next[j];
			}
			next[i] = j == -1 ? 0 : j+1;
		}
        for (int i = 0; i < next.length; i++) {
			System.out.print(next[i]);
		}
        int i = 0, j = 0;
        while (i < src.length && j < dest.length) {
        	if (src[i] == dest[j]) {
				i++;
				j++;
			}
        	else {
				j = next[j];
				if (j == -1) {
					i++;
					j = 0;
				}
			}
        }
        return j == dest.length ? i - dest.length : -1;
    }
    static public void main(String[] args) {
    	ImplementstrStr test = new ImplementstrStr();
    	test.strStr("mississippi", "issip");
    }
}
