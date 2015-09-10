package leetcode;

public class PerfectSquares {
    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }
        int[] nums = new int [n+1];
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            if ((int)Math.sqrt(i) * (int)Math.sqrt(i) == i) {
                nums[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i/2; j++) {
                if (nums[j] + nums[i-j] < min) {
                    min = nums[j] + nums[i-j];
                }
            }
            nums[i] = min;
        }
        return nums[n];
    }
}
