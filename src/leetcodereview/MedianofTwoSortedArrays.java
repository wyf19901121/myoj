/**
 * Created by wangyifan on 2018/1/3.
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;

        if ((sum & 1) == 1) {
            return findKth(nums1, 0, nums2, 0, sum/2 + 1);
        }
        else {
            return (findKth(nums1, 0, nums2, 0, sum/2 + 1)
                + findKth(nums1, 0, nums2, 0, sum/2)) / 2;
        }
    }

    public double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (nums1.length == start1) {
            return nums2[k - start1 - 1];
        }
        if (nums1.length - start1 > nums2.length - start2) {
            return findKth(nums2, start2, nums1, start1, k);
        }
        if (start1 + start2 == k - 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int real = k - start1 - start2;
        int index1 = start1 + Math.min(real/2, nums1.length - start1);
        int index2 = start2 + real - (index1 - start1);
        if (nums1[index1 - 1] == nums2[index2 - 1]) {
            return nums1[index1 - 1];
        }
        else if (nums1[index1 - 1] > nums2[index2 - 1]) {
            return findKth(nums1, start1, nums2, index2, k);
        }
        else {
            return findKth(nums1, index1, nums2, start2, k);
        }
    }
}
