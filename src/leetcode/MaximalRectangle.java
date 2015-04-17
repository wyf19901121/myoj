package leetcode;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] histogram = new int [matrix[0].length];
        int maxarea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < histogram.length; j++) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                }
                else {
                    histogram[j]++;
                }
            }
            Stack<Integer> indexIntegers = new Stack<>();
            for (int j = 0; j <= histogram.length; j++) {
                if (indexIntegers.empty() || j < histogram.length && histogram[indexIntegers.peek()] < histogram[j]) {
                    indexIntegers.push(j);
                }
                else {
                    int index = indexIntegers.pop();
                    int width = indexIntegers.empty() ? j : j - indexIntegers.peek() - 1;
                    maxarea = Math.max(maxarea, histogram[index] * width);
                    j--;
                }
            }
        }
        return maxarea;
    }
}
