package leetcode;

public class Sqrtx {
	public int mySqrt(int x) {
		int begin = 0;
		int end = (x + 1) / 2 <= 65535 && (x + 1) / 2 >= 0 ? (x + 1) / 2 : 65535;
		int mid = 0;
		int tmp = 0;
		while (begin < end) {
			mid = begin + (end - begin) / 2;
			tmp = mid * mid;
			if (tmp == x) {
				return mid;
			}
			if (tmp < x && tmp >= 0) {
				begin = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		tmp = end * end;
		if (tmp > x || tmp < 0) {
			return end - 1;
		}
		return end;
	}
}
