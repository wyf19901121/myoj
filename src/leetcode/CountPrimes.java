package leetcode;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] res = new boolean [n];
        res[0] = true;
        res[1] = true;
        for (int i = 4; i < res.length; i+=2) {
            res[i] = true;
        }
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (res[i] == false) {
                for (int j = 2; j * i < n; j++) {
                    res[j*i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == false) {
                count++;
            }
        }
        return count;
    }
}
