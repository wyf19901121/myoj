package leetcode;

public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if (num.length == 1) {
            return 0;
        }
        if (num.length == 2) {
            return num[0] > num[1] ? 0 : 1;
        }
        int res = -1;
        int mid = (num.length - 1) / 2;
        if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
            return mid;
        }
        else {
            res = findPeak(num, 0, mid - 1);
            if (res < 0) {
                res = findPeak(num, mid + 1, num.length - 1);
            }
        }
        return res;
    }
    public int findPeak(int array[], int left, int right) {
        int res = -1;
        if (right < left) {
            return res;
        }
        int mid = left + (right -left)/2;
        if (mid == 0) {
            if (array[0] > array[1]) {
                return 0;
            }
        }
        else if (mid == array.length - 1) {
            if (array[array.length - 1] > array[array.length - 2]) {
                return array.length - 1;
            }
        }
        else if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
            return mid;
        }
        res = findPeak(array, left, mid - 1);
        if (res < 0) {
            res = findPeak(array, mid + 1, right);
        }
        return res;
    }
}
