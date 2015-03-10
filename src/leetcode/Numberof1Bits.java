package leetcode;

public class Numberof1Bits {
    public int hammingWeight(int n) {
        int num = 0;
        int count = 32;
        while (count != 0) {
            if ((n & 1) == 1) {
                num++;
            }
            n >>>= 1;
            count--;
        }
        return num;
    }
}
