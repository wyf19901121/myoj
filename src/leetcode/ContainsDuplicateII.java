package leetcode;

import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer, Integer> numsIndex = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
			if (numsIndex.containsKey(nums[i]) && i - numsIndex.get(nums[i]) <= k) {
				return true;
			}
			numsIndex.put(nums[i], i);
		}
    	return false;
    }
}
