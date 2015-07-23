package leetcode;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
    	if (nums == null || nums.length == 0) {
			return -1;
		}
    	int left = 0, right = nums.length - 1;
    	while (left <= right) {
    		int mid = (left + right) / 2;
    		if (nums[mid] == target) {
				return mid;
			}
    		else if (nums[mid] >= nums[left]) {
    			if (nums[mid] > target && nums[left] <= target) {
					right = mid - 1;
				}
    			else {
					left = mid + 1;
				}
			}
    		else {
				if (nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
    	}
    	return -1;
    }
}
