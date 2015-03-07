package leetcode;

public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        if (A.length == 0 || A[0] > target || A[A.length - 1] < target) {
            int[] res = {-1, -1};
            return res;
        }
        int start = 0, end = 0;
        int left = 0, right = A.length - 1, mid = 0;
        while (left < right) { //find start
            mid = (left + right) / 2;
            if (A[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        start = A[left] == target ? left : left+1;
        left = 0;
        right = A.length - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (A[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        end = A[left] == target ? left : left-1;
        if (start > end) {
            int[] res = {-1, -1};
            return res;
        }
        int[] res = {start, end};
        return res;
    }
}
