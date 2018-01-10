/**
 * Created by wangyifan on 2018/1/10.
 */
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (div <= x / 10) {
            div *= 10;
        }
        while (div >= 10) {
            if (x / div != x % 10) {
                return false;
            }
            x %= div;
            x /= 10;
            div /= 100;
        }
        return true;
    }
}
