/**
 * Created by wangyifan on 2018/3/12.
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = i; j <= nums.length ; j++) {
                    if (j == nums.length || nums[j] <= nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j - 1];
                        nums[j - 1] = temp;
                        for (int k = i, m = nums.length - 1; k < m; k++, m--) {
                            int temp1 = nums[k];
                            nums[k] = nums[m];
                            nums[m] = temp1;
                        }
                        return;
                    }
                }
            }
        }

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
