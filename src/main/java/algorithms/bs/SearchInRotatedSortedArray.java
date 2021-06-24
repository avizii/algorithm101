package algorithms.bs;

import java.util.Arrays;

/**
 * @Author : Avizii
 * @Create : 2021.01.21
 * @CN-URL : https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * @EN-URL : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/
 * @Solve2 : https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/java-100-by-skyjeff-nx1m/
 * @Solve3 :
 */
public class SearchInRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {  // TODO 这里是 l < r 而不是 l <= r
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        return nums[l];
    }

    public int findMax(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {     // TODO 这里是 l < r 而不是 l <= r
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        return nums[l - 1];
    }

    /**
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) return m;
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }

}
