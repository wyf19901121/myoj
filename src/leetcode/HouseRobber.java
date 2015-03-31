package leetcode;

public class HouseRobber {
    public int rob(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        if (num.length == 2) {
            return Math.max(num[0], num[1]);
        }
        int[] max = new int [num.length];
        max[0] = num[0];
        max[1] = Math.max(num[0], num[1]);
        for (int i = 2; i < max.length; i++) {
            max[i] = Math.max(max[i - 2] + num[i], max[i - 1]);
        }
        return max[num.length - 1];
    }
}
