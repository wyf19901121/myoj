package leetcode;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        for (int i = 1; i <= citations.length; i++) {
            if (i > citations[citations.length - i]) {
                return i - 1;
            }
        }
        
        return citations.length;
    }
}
