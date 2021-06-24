package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.02.06
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            iMax = Math.max(iMax * num, num);
            iMin = Math.min(iMin * num, num);
            max = Math.max(max, iMax);
        }
        return max;
    }

}
