/**
 * Created by wangyifan on 2018/2/26.
 */
public class ImplementstrStr28 {
    private int[] getNext(String str) {
       if (str == null || str.length() == 0) {
           return null;
       }
       int[] next = new int[str.length()];
       next[0] = -1;
       int j = 0;
       int k = -1;
       while (j < next.length - 1) {
           if (k == -1 || str.charAt(j) == str.charAt(k)) {
               next[++j] = ++k;
           }
           else {
               k = next[k];
           }
       }
       return next;
    }
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
        int[] next = getNext(needle);

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
}
