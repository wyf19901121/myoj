package leetcode;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return A.length;
        }
        int j = 0;
        for (int i = 1; i < A.length; i++) {
			if (A[i] != A[j]) {
				A[++j] = A[i];
			}
		}
        return j+1;
    }
}
