package leetcodereview;

public class MedianofTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if ((sum & 1) == 1) {
            return findKth(nums1, 0, nums2, 0, sum/2 + 1);
        }
        else {
            return (findKth(nums1, 0, nums2, 0, sum/2 + 1) 
                    + findKth(nums1, 0, nums2, 0, sum/2))/2;
        }
    }
    
    public double findKth(int[] num1, int start1, int[] num2, int start2, int k) {
        if (start1 == num1.length) {
            return num2[k - start1 - 1];
        }
        if (num1.length - start1 > num2.length - start2) {
            return findKth(num2, start2, num1, start1, k);
        }
        if (start1 + start2 == k - 1) {
            return Math.min(num1[start1], num2[start2]);
        }
        int real = k - start1 - start2;
        int index1 = start1 + Math.min(real/2, num1.length - start1);
        int index2 = start2 + real - index1 + start1;
        if (num1[index1 - 1] == num2[index2 - 1]) {
            return num1[index1 - 1];
        }
        else if (num1[index1 - 1] > num2[index2 - 1]) {
            return findKth(num1, start1, num2, index2, k);
        }
        else {
            return findKth(num1, index1, num2, start2, k);
        }
    }
}
