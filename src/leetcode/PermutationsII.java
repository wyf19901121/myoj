package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
			return res;
		}
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        dfs(num, temp, used);
        return res;
    }
    public void dfs(int[] num, ArrayList<Integer> temp, boolean[] used) {
		if (temp.size() == num.length) {
		    @SuppressWarnings("unchecked")
            ArrayList<Integer> tempArrayList = (ArrayList<Integer>) temp.clone();
			res.add(tempArrayList);
			return;
		}
		for (int i = 0; i < num.length; i++) {
		    if (i > 0 && !used[i-1] && num[i] == num[i-1]) {
                continue;
            }
		    if (!used[i]) {
	            temp.add(num[i]);
	            used[i] = true;
	            dfs(num, temp, used);
	            temp.remove(temp.size() - 1);
	            used[i] = false;
            }
        }
	}
}
