package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> resIntegers = new HashSet<>();
        int sum = n;
        while (sum != 1) {
            n = sum;
            sum = 0;
            while (n != 0) {
                sum += (n%10) * (n%10);
                n = n / 10;
            }
            if (resIntegers.contains(sum)) {
                return false;
            }
            resIntegers.add(sum);
            n = sum;
        }
        return true;
    }
}
