package leetcode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + i - nums[i];
        }
        return sum + nums.length;
    }
}
