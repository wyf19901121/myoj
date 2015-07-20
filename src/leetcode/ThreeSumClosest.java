package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
			return 0;
		}
        Arrays.sort(nums);
        int curSum = 0, curDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int tempSum = nums[i] + nums[j] + nums[k];
				int tempDiff = Math.abs(tempSum - target);
				if (tempDiff < curDiff) {
					curSum = tempSum;
					curDiff = tempDiff;
					if (tempDiff == 0) {
						return curSum;
					}
				}
				else if (tempSum < target) {
					j++;
				}
				else {
					k--;
				}
			}
		}
        return curSum;
    }
}
