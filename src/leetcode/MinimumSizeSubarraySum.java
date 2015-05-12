package leetcode;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
        int left = 0, right = 0, length = 0, sum = 0; 
        while (right < nums.length) {
			if (sum >= s) {
				length = Math.min(length == 0 ? Integer.MAX_VALUE : length, right - left);
				sum -= nums[left++];
			}
			else {
				sum += nums[right++];
			}
		}
        while (sum >= s && left != right) {
			if (sum >= s) {
				length = Math.min(length == 0 ? Integer.MAX_VALUE : length, right - left);
			}
			sum -= nums[left++];
		}
        return length;
    }
}
