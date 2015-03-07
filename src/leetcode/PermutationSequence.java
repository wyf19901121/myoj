package leetcode;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum *= i;
        }
        boolean [] used = new boolean [n];
        char [] res = new char [n];
        int pos = 0;
        int num = 0;
        k--;
        for (int i = 0; i < n; i++) {
            pos = k/sum;
            for (int j = 0; j < used.length; j++) {
                if (used[j] == false) {
                    if (pos == 0) {
                        num = j;
                        used[j] = true;
                        break;
                    }
                    else {
                        pos--;
                    }
                }
            }
            res[i] = (char) ('1' + num);
            k = k % sum;
            if (i != n - 1) {
                sum /= n - 1 - i;
            }
        }
        return String.copyValueOf(res);
    }
}
