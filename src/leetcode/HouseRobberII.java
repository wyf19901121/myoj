package leetcode;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
			return 0;
		}
        if (nums.length == 1) {
			return nums[0];
		}
        int[] max = new int [nums.length];
        max[0] = nums[0];
        max[1] = nums[0];
        for (int i = 2; i < max.length; i++) {
			max[i] = Math.max(max[i-1], max[i-2]+nums[i]);
		}
        int tempmax = max[nums.length - 2];
        max[0] = 0;
        max[1] = nums[1];
        for (int i = 2; i < max.length; i++) {
			max[i] = Math.max(max[i-1], max[i-2]+nums[i]);
		}
        return Math.max(tempmax, max[nums.length - 1]);
    }
}
