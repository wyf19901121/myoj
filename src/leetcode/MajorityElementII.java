package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
    	if (nums.length == 0) {
			return new ArrayList<Integer>();
		}
    	int num1 = 0, num2 = 0;
    	int count1 = 0, count2 = 0;
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			if (count1 == 0 || nums[i] == num1) {
				count1++;
				num1 = nums[i];
				continue;
			}
			if (count2 == 0 || nums[i] == num2) {
				count2++;
				num2 = nums[i];
				continue;
			}
			count1--;
			count2--;
		}
    	count1 = 0;
    	count2 = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == num1) {
				count1++;
				continue;
			}
    		if (nums[i] == num2) {
				count2++;
				continue;
			}
		}
    	if (count1 > nums.length / 3) {
			res.add(num1);
		}
    	if (count2 > nums.length / 3) {
			res.add(num2);
		}
    	return res;
    }
}
