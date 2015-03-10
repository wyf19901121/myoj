package leetcode;

public class JumpGameII {
    public int jump(int[] A) {
        int curRch = 0, curMax = 0, ret = 0;
        for (int i = 0; i < A.length; i++) {
            if (curRch < i) {
                ret++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, i+A[i]);
        }
        return ret;
    }
}
