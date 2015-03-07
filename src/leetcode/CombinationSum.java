package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public ArrayList<List<Integer>> res = new ArrayList<List<Integer>> ();
    public ArrayList<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        combian(candidates, 0, target, new ArrayList<Integer>());
        return res;
    }
    public void combian(int[] src, int start, int sum, ArrayList<Integer> temp) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i < src.length; i++) {
            if (i > 0 && src[i] == src[i-1]) {
                continue;
            }
            temp.add(src[i]);
            combian(src, i, sum-src[i], temp);
            temp.remove(temp.size()-1);
        }
    }
}
