package leetcode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
    	int max = Integer.MIN_VALUE;
    	int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];
			max = Math.max(curSum, max);
			if (curSum < 0) {
				curSum = 0;
			}
		}
        return max;
    }
}
