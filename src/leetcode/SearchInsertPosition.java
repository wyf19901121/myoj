package leetcode;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A[0] >= target) {
            return 0;
        }
        if (A[A.length-1] < target) {
            return A.length;
        }
        int left = 0, right = A.length-1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
