package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<String>();
        int left = 0;
        for (int i = 1; i <= nums.length; i++) {
			if (i == nums.length || nums[i] != nums[i-1] + 1) {
				if (i - 1 == left) {
					res.add(String.valueOf(nums[left]));
				}
				else {
					res.add(nums[left] + "->" + nums[i-1]);
				}
				left = i;
			}
		}
        return res;
    }
}
