package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    public ArrayList<List<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        combian(0, target, num, new ArrayList<Integer>());
        return res;
    }
    public void combian(int start, int sum, int[] num, ArrayList<Integer> temp) {
        if (sum == 0) {
            res.add(new ArrayList<Integer>(temp));
            return ;
        }
        if (sum < 0 || start == num.length) {
            return ;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i-1]) {
                continue;
            }
            temp.add(num[i]);
            combian(i+1, sum-num[i], num, temp);
            temp.remove(temp.size()-1);
        }
    }
}
