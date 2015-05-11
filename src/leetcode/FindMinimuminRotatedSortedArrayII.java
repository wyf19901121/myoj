package leetcode;

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
        	if (nums[low] < nums[high]) {
				return nums[low];
			}
        	int mid = low + (high - low) / 2;
        	if (nums[mid] == nums[low]) {
				if (low + 1 == high) {
					low = high;
					break;
				}
				low++;
			}
        	else if (nums[mid] > nums[low]) {
				low = mid;
			}
        	else {
				high = mid;
			}
		}
        return nums[low];
    }
}
