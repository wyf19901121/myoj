package leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0 || k == 0) {
//            return new int[0];
//        }
//        Queue<Integer> heap = new PriorityQueue<Integer> (k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer num1, Integer num2) {
//                return num2 - num1;
//            }
//        });
//        int[] max = new int [nums.length - k + 1];
//        for (int i = 0; i < k - 1; i++) {
//            heap.add(nums[i]);
//        }
//        for (int i = 0; i < max.length; i++) {
//            heap.add(nums[k - 1 + i]);
//            max[i] = heap.peek();
//            heap.remove(nums[i]);
//        }
//        return max;
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> result = new LinkedList<Integer>();
        int left = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < k - 1; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                for (int j = left + 1; j <= i; j++) {
                    result.addLast(nums[j]);
                }
                left = i;
            }
        }
        int[] maxs = new int [nums.length - k + 1];
        for (int i = k - 1 ; i < nums.length; i++) {
            if (nums[i] >= max || result.isEmpty()) {
                max = !result.isEmpty() ? max : Integer.MIN_VALUE;
                for (int j = left + 1; j <= i; j++) {
                    if (nums[j] >= max) {
                        for (int j2 = left + 1; j2 <= j; j2++) {
                            result.addLast(nums[j2]);
                        }
                        max = nums[j];
                        left = j;
                    }
                }
            }
            maxs[i - k + 1] = max;
            result.removeFirst();
        }
        return maxs;
    }
}
