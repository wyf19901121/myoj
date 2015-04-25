package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int temlen = 1, tempnum;
            tempnum = nums[i] + 1;
            while (hash.contains(tempnum)) {
                hash.remove(tempnum);
                tempnum++;
                temlen++;
                
            }
            tempnum = nums[i] - 1;
            while (hash.contains(tempnum)) {
                hash.remove(tempnum);
                tempnum--;
                temlen++;
            }
            res = Math.max(temlen, res);
            if (res >= nums.length) {
                return res;
            }
        }
        return res;
    }
}
