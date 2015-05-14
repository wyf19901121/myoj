package leetcode;

public class MaximumGap {
    class bucket {
        int num = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        public bucket() {
            // TODO Auto-generated constructor stub
        }
        public void add(Integer element) {
            min = Math.min(min, element);
            max = Math.max(max, element);
            num++;
        }
    }
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] - nums[1] > 0 ? nums[0] - nums[1] : nums[1] - nums[0];
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max - min <= 1) {
            return max - min;
        }
        int len = (max - min)/ (nums.length - 1) + 1;
        bucket[] buckets = new bucket[(max - min)/len + 1];
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min)/len;
            if (buckets[index] == null) {
                buckets[index] = new bucket();
            }
            buckets[index].add(nums[i]);
        }
        int maxGap = 0, lastbucket = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] != null) {
                maxGap = Math.max(maxGap, buckets[i].min - buckets[lastbucket].max);
                lastbucket = i;
            }
        }
        return maxGap;
    }
}
