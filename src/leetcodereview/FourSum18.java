import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangyifan on 2018/2/1.
 */

public class FourSum18 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> answer = new ArrayList<>();
    private void nSum(int num, int[] nums, int target, int start) {
        if (start + num > nums.length) {
            return;
        }
        if (num == 2) {
            int j = start, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> res = new ArrayList<>();
                    for (Integer ele: answer) {
                        res.add(ele);
                    }
                    res.add(nums[j]);
                    res.add(nums[k]);
                    result.add(res);
                    int left = nums[j];
                    while (j < k && nums[j] == left) {
                        j++;
                    }
                }
                else if (nums[j] + nums[k] < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        else {
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[i-1]) {
                    continue;
                }
                answer.add(nums[i]);
                nSum(num - 1, nums, target - nums[i], i + 1);
                answer.remove(answer.size() - 1);
            }
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        nSum(4, nums, target, 0);
        return result;
    }
}
