package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i-1]) {
				continue;
			}
			if (nums[i] > 0) {
				return res;
			}
			int j = i + 1, k = nums.length - 1;
			int sum = 0 - nums[i];
			while (j < k) {
				if (j != i+1 && nums[j] == nums[j - 1]) {
					j++;
					continue;
				}
				if (k != nums.length - 1 && nums[k] == nums[k+1]) {
					k--;
					continue;
				}
				if (nums[j] + nums[k] == sum) {
					ArrayList<Integer> tempRes = new ArrayList<Integer>(3);
					tempRes.add(nums[i]);
					tempRes.add(nums[j]);
					tempRes.add(nums[k]);
					res.add(tempRes);
					j++;
					k--;
				}
				else if (nums[j] + nums[k] < sum) {
					j++;
				}
				else {
					k--;
				}
			}
		}
    	return res;
    }
}
