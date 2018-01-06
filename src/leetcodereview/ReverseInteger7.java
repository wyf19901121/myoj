/**
 * Created by wangyifan on 2018/1/6.
 */
public class ReverseInteger7 {
    public int reverse(int x) {
        boolean minus = x < 0;
        long abs = Math.abs(x);
        long rev = 0;
        while (abs > 0) {
            rev = 10 * rev + abs % 10;
            abs = abs / 10;
        }
        rev = minus ? 0 - rev : rev;
        rev = rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE ? 0 : rev;

        return (int)rev;
    }
}
