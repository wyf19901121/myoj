package leetcode;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, k, 0, nums.length - 1);
    }
    public int findKth(int[] nums, int k, int left, int right) {
		int l = left, r = right, m = nums[left];
		while (r > l) {
			while (r > l && nums[r] < m) {r--;}
			if (r <= l) {
				break;
			}
			else {
				nums[l++] =  nums[r];
			}
			while (r > l && nums[l] >= m) {l++;}
			if (r <= l) {
				break;
			}
			else {
				nums[r--] = nums[l];
			}
		}
		nums[l] = m;
		if (l - left == k - 1) {
			return m;
		}
		else if (l - left > k - 1) {
			return findKth(nums, k, left, r - 1);
		}
		else {
			return findKth(nums, k - (l - left) - 1, l + 1, right);
		}
	}
}
