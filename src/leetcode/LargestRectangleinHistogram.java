package leetcode;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        int area = 0;
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            if (index.empty() || (i < height.length && height[index.peek()] < height[i])) {
                index.push(i);
            }
            else {
                int start = index.pop();
                int width = index.empty() ? i : i - index.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        return area;
    }
}
