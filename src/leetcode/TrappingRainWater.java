package leetcode;

public class TrappingRainWater {
    public int trap(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int i = 0, j = A.length - 1, left = A[i], right = A[j];
        int sum = 0;
        while (j - i > 1) {
            if (left >= right) {
                if (A[j - 1] < right) {
                    sum += right - A[--j];
                }
                else {
                    right = A[--j];
                }
            }
            else {
                if (A[i + 1] < left) {
                    sum += left - A[++i];
                }
                else {
                    left = A[++i];
                }
            }
        }
        return sum;
    }
}
