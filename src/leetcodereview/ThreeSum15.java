/**
 * Created by wangyifan on 2018/1/29.
 */

import java.util.*;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length -2 && nums[i] <= 0; i++) {
            int left = i+1, right = nums.length - 1;
            while (left < right) {
                int leftPos = left, rightPos = right;
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> numList = new ArrayList<>();
                    numList.add(nums[i]);
                    numList.add(nums[left]);
                    numList.add(nums[right]);
                    resultList.add(numList);
                    while (left < right && nums[left] == nums[leftPos] && nums[right] == nums[rightPos]) {
                        left++;
                        right--;
                    }
                }
                else if (nums[i] + nums[left] + nums[right] < 0) {
                    while (left < right && nums[left] == nums[leftPos]) {
                        left++;
                    }
                }
                else {
                    while (left < right && nums[right] == nums[rightPos]) {
                        right--;
                    }
                }
            }
            while (i < nums.length -2 && nums[i] <= 0 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return resultList;
    }
}
