package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> temp = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i])) {
				return true;
			}
			temp.add(nums[i]);
		}
        return false;
    }
}
