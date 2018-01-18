/**
 * Created by wangyifan on 2018/1/14.
 */
public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}
