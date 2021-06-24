package algorithms.bs;

/**
 * @Author : Avizii
 * @Create : 2021.03.11
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length;
        int r = nums2.length;
        int[] nums = new int[l + r];
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) nums[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        while (i < l) nums[k++] = nums1[i++];
        while (j < r) nums[k++] = nums2[j++];

        int mid = nums.length / 2;
        return nums.length % 2 == 0 ? (nums[mid - 1] + nums[mid]) / 2.0 : nums[mid];
    }
}
