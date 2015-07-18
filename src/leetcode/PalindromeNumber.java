package leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int base = 1;
		int num = x;
		while (num/base >= 10) {
			base *= 10;
		}
		while (num > 0) {
			if (num / base != num % 10) {
				return false;
			}
			num %= base;
			num /= 10;
			base /= 100;
		}
		return true;
	}
}
