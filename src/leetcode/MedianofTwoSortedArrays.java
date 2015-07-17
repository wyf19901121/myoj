package leetcode;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int total = len1 + len2;
        if ((total & 0x1) == 1) {
            return findKth(nums1, 0, nums2, 0, total/2 + 1);
        }
        else {
            return (findKth(nums1, 0, nums2, 0, total/2)
                    + findKth(nums1, 0, nums2, 0, total/2 + 1)) / 2;
        }
    }
    
    public double findKth(int[] longArray, int longStart,
            int[] shortArray, int shortStart, int k) {
        int longLen = longArray.length - longStart, shortLen = shortArray.length - shortStart;
        if (longLen < shortLen) {
            return findKth(shortArray, shortStart, longArray, longStart, k);
        }
        if (shortLen == 0) {
            return longArray[k - 1 - shortStart];
        }
        if (k == longStart + shortStart + 1) {
            return Math.min(longArray[longStart], shortArray[shortStart]);
        }
        int shortIndex = 0, longIndex = 0;
        int trueK = k - shortStart - longStart;
        int shortIncrease = Math.min(trueK / 2, shortArray.length - shortStart);
        int longIncrease = trueK - shortIncrease;
        shortIndex = shortStart + shortIncrease;
        longIndex = longStart + longIncrease;
        if (longArray[longIndex - 1] < shortArray[shortIndex - 1]) {
            return findKth(longArray, longIndex, shortArray, shortStart, k);
        }
        else if (longArray[longIndex - 1] > shortArray[shortIndex - 1]) {
            return findKth(longArray, longStart, shortArray, shortIndex, k);
        }
        else {
            return longArray[longIndex - 1];
        }
    }
}
