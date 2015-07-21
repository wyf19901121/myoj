package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> targetSum = new ArrayList<List<Integer>>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
			return targetSum;
		}
        int[] sum = new int[4];
        Arrays.sort(nums);
        nSum(nums, target, 4, 0, sum, 0);
        return targetSum;
    }
    public void nSum(int[] nums, int target, int n, int startIndex, int[] curSum, int curIndex) {
		if (n < 2) {
			return;
		}
		if (n == 2) {
			int i = startIndex, j = nums.length - 1;
			while (i < j) {
				if (i != startIndex && nums[i] == nums[i-1]) {
					i++;
					continue;
				}
				if (j != nums.length - 1 && nums[j] == nums[j+1]) {
					j--;
					continue;
				}
				if (nums[i] + nums[j] == target) {
					curSum[curIndex] = nums[i];
					curSum[curIndex+1] = nums[j];
					ArrayList<Integer> tempTargetSum = new ArrayList<Integer>();
					for (int k = 0; k < curSum.length; k++) {
						tempTargetSum.add(curSum[k]);
					}
					targetSum.add(tempTargetSum);
					i++;
				}
				else if (nums[i] + nums[j] < target) {
					i++;
				}
				else {
					j--;
				}
			}
		}
		else {
			for (int i = startIndex; i < nums.length - n + 1; i++) {
				if (i != startIndex && nums[i] == nums[i-1]) {
					continue;
				}
				curSum[curIndex] = nums[i];
				nSum(nums, target-nums[i], n-1, i+1, curSum, curIndex+1);
			}
		}
	}
}
