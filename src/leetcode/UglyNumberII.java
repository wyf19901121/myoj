package leetcode;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        
        int[] uglys = new int [n];
        uglys[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < uglys.length; i++) {
            uglys[i] = Math.min(Math.min(2*uglys[index2], 3*uglys[index3]), 5*uglys[index5]);
            if (2 * uglys[index2] <= uglys[i]) {
                index2++;
            }
            if (3 * uglys[index3] <= uglys[i]) {
                index3++;
            }
            if (5 * uglys[index5] <= uglys[i]) {
                index5++;
            }
        }
        return uglys[n-1];
    }
}
