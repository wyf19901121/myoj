package homework;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
			return;
		}
        k = k % nums.length;
        if (k == 0) {
			return;
		}
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return;
    }
    
    public void reverse(int[] array, int left, int right) {
		int head = left, tail = right, mid = left + (right - left + 1)/2;
		while (head != mid) {
			int temp = array[head];
			array[head] = array[tail];
			array[tail] = temp;
			head++;
			tail--;
		}
		return ;
	}
}
