package algorithms.bs;

/**
 * @Author : Avizii
 * @Create : 2021.01.21
 *
 *  https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class BinarySearchTemplate {

    public int binarySearch(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == value) return m;
            if (nums[m] < value) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    /**
     * 查找有序数组中第一个等于给定值的元素
     */
    public int bsFirstValue(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > value) r = m - 1;
            else if (nums[m] < value) l = m + 1;
            else {
                if (m == 0 || nums[m - 1] != value) return m;
                else r = m - 1;
            }
        }
        return -1;
    }

    /**
     * 查找有序数组中最后一个等于给定值的元素
     */
    public int bsLastValue(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > value) r = m - 1;
            else if (nums[m] < value) l = m + 1;
            else {
                if (m == nums.length - 1 || nums[m + 1] != value) return m;
                else l = m + 1;
            }
        }
        return -1;
    }

    //变体三：查找第一个大于等于给定值的元素
    public int bsFirstGEValue(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < value) l = m + 1;
            else {
                // m为数组第一个 或 m的前一个小于value
                if (m == 0 || nums[m - 1] < value) return m;
                r = m - 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    public int bsLastLEValue(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > value) r = m - 1;
            else {
                // m为数组最后一个 或 m的下一个大于value
                if (m == nums.length - 1 || nums[m + 1] > value) return m;
                l = m + 1;
            }
        }
        return -1;
    }
}
