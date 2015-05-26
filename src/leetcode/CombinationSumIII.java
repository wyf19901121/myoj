package leetcode;

import java.util.ArrayList;

public class CombinationSumIII {
	public ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
    	int[] tempArray = new int [k];
        addnum(tempArray, 1, k, n);
        return res;
    }
    public void addnum(int[] nums, int index, int num, int sum){
    	if (sum == 0 && num == 0) {
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		for (int i = 0; i < nums.length; i++) {
				temp.add(nums[i]);
			}
			res.add(temp);
			return;
		}
    	else if (num == 0 || sum <= 0) {
			return;
		}
    	int len = nums.length;
    	int j = len - num;
    	for (int i = index; i <= 9 && i <= sum/num; i++) {
			nums[j] = i;
			addnum(nums, i+1, num-1, sum-i);
		}
    	return;
    }
}
