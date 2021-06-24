package array;

/**
 * @Author : Avizii
 * @Create : 2021.01.14
 * @CN-URL : https://leetcode-cn.com/problems/merge-sorted-array
 * @EN-URL : https://leetcode.com/problems/merge-sorted-array
 * @Solve1 : https://leetcode-cn.com/problems/merge-sorted-array/solution/hua-jie-suan-fa-88-he-bing-liang-ge-you-xu-shu-zu-/
 * @Solve2 :
 * @Solve3 :
 */
public class MergeSortedArray {

    /**
     * 标签：从后向前数组遍历
     * 因为 nums1 的空间都集中在后面，所以从后向前处理排序的数据会更好，节省空间，一边遍历一边将值填充进去
     * 设置指针 len1 和 len2 分别指向 nums1 和 nums2 的有数字尾部，
     * 从尾部值开始比较遍历，同时设置指针 len 指向 nums1 的最末尾，每次遍历比较值大小之后，则进行填充
     * 当 len1<0 时遍历结束，此时 nums2 中海油数据未拷贝完全，将其直接拷贝到 nums1 的前面，最后得到结果数组
     * 时间复杂度：O(m+n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m - 1, l2 = n - 1, l = m + n - 1;
        while (l1 >= 0 && l2 >= 0) {
            nums1[l--] = nums1[l1] > nums2[l2] ? nums1[l1--] : nums2[l2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, l2 + 1);
    }

}
