/**
 * Created by wangyifan on 2017/12/22.
 */

package leetcodereview;
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] orignalNumbers = new int[nums.length];
        orignalNumbers = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                break;
            }
            else if (nums[left]+ nums[right] <target) {
                left++;
            }
            else {
                right--;
            }
        }

        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (result[0] == -1) {
                result[0] = orignalNumbers[i] == nums[left] || orignalNumbers[i] == nums[right]
                        ? i : result[0];
            }
            else {
                result[1] = orignalNumbers[i] == nums[left] || orignalNumbers[i] == nums[right]
                        ? i : result[1];
            }
        }
        return result;
    }
}
