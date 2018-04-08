/**
 * Created by wangyifan on 2018/4/8.
 */
public class SearchforaRange34 {
    public int findRange(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || left && nums[mid] == target) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};

        int left = findRange(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return range;
        }

        int right = findRange(nums, target, false) - 1;

        range[0] = left;
        range[1] = right;

        return range;
    }
}
