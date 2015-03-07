package leetcode;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            res = 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return res;
        }
        boolean isNeg = ((dividend ^ divisor) >>> 31) == 1 ? true : false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while (divisor <= (dividend >> 1)) {
            divisor <<= 1;
            digit++;
        }
        int temp = 0;
        while (digit >= 0) {
            if (dividend >= divisor) {
                dividend -= divisor;
                temp += 1 << digit;
            }
            divisor >>= 1;
            digit--;
        }
        if (!isNeg && temp == Integer.MAX_VALUE) {
            return temp;
        }
        temp += res;
        return isNeg ? -temp : temp;
    }
}
