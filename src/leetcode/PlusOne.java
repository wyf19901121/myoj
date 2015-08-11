package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int i;
        for (i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				return digits;
			}
			else {
				digits[i] = 0;
			}
		}
        if (i < 0) {
			int[] newdigits = new int [digits.length + 1];
			newdigits[0] = 1;
			System.arraycopy(digits, 0, newdigits, 1, digits.length);
			return newdigits;
		}
        return digits;
    }
}
