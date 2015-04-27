package leetcode;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
			return 1;
		}
        if (ratings.length == 0) {
			return 0;
		}
        int[] cans = new int[ratings.length];
        cans[0] = 1;
        for (int i = 1; i < cans.length; i++) {
			if (ratings[i] > ratings[i-1]) {
				cans[i] = cans[i-1] + 1;
			}
			else {
				cans[i] = 1;
			}
		}
        for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i+1] && cans[i] <= cans[i+1]) {
				cans[i] = cans[i+1] + 1;
			}
		}
        int ret = 0;
        for (int i = 0; i < cans.length; i++) {
			ret += cans[i];
		}
        return ret;
    }
}
