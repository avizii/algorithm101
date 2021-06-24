package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.02.06
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
 *          看题解下面的评论
 */
public class MaximumSubarray {

    // dp[i] 定义为数组nums 中已num[i] 结尾的最大连续子串和， 则有dp[i] = max(dp[i-1] + nums[i], num[i]);
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArraySpace(int[] nums) {
        int max = nums[0], pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

}
