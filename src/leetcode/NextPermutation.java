package leetcode;

public class NextPermutation {
    public void nextPermutation(int[] num) {
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i-1]) {
                for (int j = num.length - 1; j > i - 1; j--) {
                    if (num[j] > num[i-1]) {
                        int temp = num[j];
                        num[j] = num[i-1];
                        num[i-1] = temp;
                        for (int k = 0; k < (num.length - i)/2; k++) {
                            int temp1 = num[i+k];
                            num[i+k] = num[num.length - k - 1];
                            num[num.length - k - 1] = temp1;
                        }
                        return ;
                    }
                }
            }
        }
        for (int i = 0; i < num.length / 2; i++) {
            int temp = num[i];
            num[i] = num[num.length - i - 1];
            num[num.length - i - 1] = temp;
        }
    }
}
