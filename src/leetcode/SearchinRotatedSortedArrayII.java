package leetcode;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int left = 0, right = A.length - 1;
        while (left < right) {
            if (A[left] == target || A[right] == target) {
                return true;
            }
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] == A[left] && A[mid] == A[right]) {
                return searchInSort(A, target);
            }
            if (A[mid] < target) {
                if (A[mid] >= A[left]) {
                    left = mid + 1;
                }
                else {
                    if (A[left] < target) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
            else {
                if (A[mid] <= A[right]) {
                    right = mid - 1;
                }
                else {
                    if (target > A[left]) {
                        right = mid -1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
        }
        return A[left] == target;
    }
    public boolean searchInSort(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
