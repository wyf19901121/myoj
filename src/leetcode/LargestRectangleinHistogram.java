package leetcode;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        int area = 0;
        Stack<Integer> indexs = new Stack<Integer>();
        for (int i = 0; i <= height.length; i++) {
            if (indexs.empty() || (i < height.length && height[indexs.peek()] < height[i])) {
                indexs.push(i);
            }
            else {
                int start = indexs.pop();
                int width = indexs.empty() ? i : i - indexs.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        return area;
    }
}
