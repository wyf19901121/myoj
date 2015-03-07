package leetcode;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int c5 = 0;
        for (int i = 5; i <= n; i+=5) {
            int temp = i;
            while (temp % 5 == 0) {
                c5++;
                temp = temp / 5;
            }
        }
        return c5;
    }
}
