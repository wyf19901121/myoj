package leetcode;

public class FirstBadVersion {
    boolean isBadVersion(int version) {
        return true;
    }
    public int firstBadVersion(int n) {
        long left = 1, right = n;
        long mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (isBadVersion((int) mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return (int) (isBadVersion((int) left) ? left : left + 1);
    }
}
