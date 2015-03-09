package leetcode;

import java.util.ArrayList;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
			return res;
		}
        dfs(0, num);
        return res;
    }
    public void dfs(int i, int[] num) {
		if (i == num.length) {
			ArrayList<Integer> tempArrayList = new ArrayList<>();
			for (int j = 0; j < num.length; j++) {
				tempArrayList.add(num[j]);
			}
			res.add(tempArrayList);
			return;
		}
		for (int j = i; j < num.length; j++) {
			if (j != i && num[j] == num[i]) {
				continue;
			}
			int tmp = num[i];
			num[i] = num[j];
			num[j] = tmp;
			dfs(i+1, num);
			tmp = num[j];
			num[j] = num[i];
			num[i] = tmp;
		}		
	}
}
