package leetcode;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int [nums.length];
        res[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i+1] * nums[i+1];
        }
        int left = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] *= left;
            left *= nums[i];
        }
        return res;
    }
}
