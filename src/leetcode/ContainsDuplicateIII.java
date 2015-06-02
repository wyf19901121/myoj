package leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if (k < 1 || t < 0 || nums == null || nums.length < 2) {
			return false;
		}
    	
    	TreeSet<Long> numSet = new TreeSet<Long>();
    	for (int i = 0; i < nums.length; i++) {
			SortedSet<Long> subSortedSet = numSet.subSet((long)nums[i] - t, (long)nums[i] + t + 1);
			if (!subSortedSet.isEmpty()) {
				return true;
			}
			if (i >= k) {
				numSet.remove((long)nums[i - k]);
			}
			numSet.add((long)nums[i]);
		}
    	return false;
    }
}
