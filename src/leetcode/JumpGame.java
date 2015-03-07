package leetcode;

public class JumpGame {
    public boolean canJump(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > max) {
                return false;
            }
            if (max >= A.length - 1) {
                return true;
            }
            max = Math.max(max, i+A[i]);
        }
        return true;
    }
}
