package leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i + 1 && A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                int index = A[i] - 1;
                int tmp = A[i];
                A[i] = A[index];
                A[index] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
