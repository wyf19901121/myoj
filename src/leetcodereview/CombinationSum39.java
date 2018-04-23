/**
 * Created by wangyifan on 2018/4/23.
 */
import java.util.*;

public class CombinationSum39 {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> temp = new ArrayList<>();

    private void getCombination(int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            temp.add(candidates[i]);
            getCombination(candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        getCombination(candidates, target, 0);

        return res;
    }
}
