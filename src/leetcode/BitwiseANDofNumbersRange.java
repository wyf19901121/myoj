package leetcode;

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int num = m ^ n;
        int lognum = (int) (Math.log(num) / Math.log(2));
        return m >> lognum + 1 << lognum + 1;
    }
}
