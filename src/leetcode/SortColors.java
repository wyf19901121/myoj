package leetcode;

public class SortColors {
    public void sortColors(int[] A) {
        int i = 0, zero = 0, two = A.length - 1;
        while (i < A.length) {
            switch (A[i]) {
            case 0:
                if (i == zero) {
                    i++;
                }
                else {
                    int tmp = A[zero];
                    A[zero] = 0;
                    A[i] = tmp;
                }
                zero++;
                break;
            case 1:
                i++;
                break;
            case 2:
                if (i >= two) {
                    return ;
                }
                int tmp = A[two];
                A[two] = 2;
                A[i] = tmp;
                two--;
                break;
            default:
                break;
            }
        }
    }
}
