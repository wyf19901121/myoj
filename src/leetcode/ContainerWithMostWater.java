package leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    	if (height == null || height.length == 0) {
			return 0;
		}
    	int i = 0, j = height.length - 1;
    	int max = 0;
    	while (i < j) {
			int area = Math.min(height[i], height[j]) * (j - i);
			max = Math.max(area, max);
			if (height[i] < height[j]) {
				i++;
			}
			else {
				j--;
			}
		}
    	return max;
    }
}
