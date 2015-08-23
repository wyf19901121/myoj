package leetcode;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        result = result & ~(result - 1);
        int[] res = new int [2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & result) == 0) {
                res[0] ^= nums[i];
            }
            else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
