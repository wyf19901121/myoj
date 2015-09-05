package leetcode;

public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        if (citations.length <= citations[0]) {
            return citations.length;
        }
        if (1 > citations[citations.length - 1]) {
            return 0;
        }
        int len = citations.length;
        int left = 0, right = len - 1;
        int mid = left + (right - left) / 2;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            int index = len - mid;
            if (index > citations[mid]) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return citations.length - right;
    }
}
