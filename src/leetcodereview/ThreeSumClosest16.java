import java.util.Arrays;

/**
 * Created by wangyifan on 2018/1/30.
 */
public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int curSum = 0, curDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tempSum = nums[i] + nums[j] + nums[k];
                int tempDiff = Math.abs(tempSum - target);
                if (tempDiff == 0) {
                    return tempSum;
                }
                if (tempDiff < curDiff) {
                    curDiff = tempDiff;
                    curSum = tempSum;
                }
                else if (tempSum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return curSum;
    }
}
