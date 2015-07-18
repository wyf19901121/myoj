package leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		long newNum = 0;
		boolean minus = false;
		if (x < 0) {
			minus = true;
		}
		int oldNum = Math.abs(x);
		while (oldNum > 0) {
			newNum = newNum * 10 + oldNum % 10;
			oldNum /= 10;
		}
		newNum = minus ? -newNum : newNum;
		if (newNum > Integer.MAX_VALUE || newNum < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) newNum;
	}
}
