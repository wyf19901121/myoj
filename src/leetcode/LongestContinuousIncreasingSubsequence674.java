package src.leetcode;


public class LongestContinuousIncreasingSubsequence674 {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        int curLen = 1;
        if (nums == null || nums.length == 0)
            return maxLen;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
            }
            else {
                curLen++;
            }
        }
        return Math.max(maxLen, curLen);
    }
}
