package leetcode;

import java.util.Arrays;

public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
			return null;
		}
        int[] newNumbers = new int [nums.length];
        System.arraycopy(nums, 0, newNumbers, 0, nums.length);
        Arrays.sort(nums, 0, nums.length);
        int left = 0, right = nums.length - 1;
        while (left < right) {
			if (nums[left] + nums[right] < target) {
				left++;
			}
			else if (nums[left] + nums[right] > target) {
				right--;
			}
			else {
				left = nums[left];
				right = nums[right];
				break;
			}
		}
        int counter = 0;
        int[] indexs = new int[2];
        for (int i = 0; i < newNumbers.length; i++) {
			if (newNumbers[i] == left || newNumbers[i] == right) {
				indexs[counter++] = i + 1;
			}
		}
        return indexs;
    }
}
