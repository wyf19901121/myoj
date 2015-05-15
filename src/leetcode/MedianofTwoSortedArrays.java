package leetcode;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return findKth(nums1, nums2, total/2 + 1);
        }
        else {
            return (findKth(nums1, nums2, total/2 + 1) + findKth(nums1, nums2, total/2)) / 2; 
        }
    }
    public double findKth(int[] a, int[] b, int k) {
        if (a.length > b.length) {
            return findKth(b, a, k);
        }
        if (a.length == 0) {
            return b[k-1];
        }
        if (k == 1) {
            return Math.min(a[0], b[0]);
        }
        int pa = Math.min(k/2, a.length), pb = k - pa;
        if (a[pa - 1] < b[pb - 1]) {
            int[] nums = new int [a.length - pa];
            System.arraycopy(a, pa, nums, 0, nums.length);
            return findKth(nums, b, k - pa);
        }
        else if (a[pa - 1] > b[pb - 1]) {
            int[] nums = new int [b.length - pb];
            System.arraycopy(b, pb, nums, 0, nums.length);
            return findKth(a, nums, k - pb);
        }
        else {
            return a[pa - 1];
        }
    }
}
