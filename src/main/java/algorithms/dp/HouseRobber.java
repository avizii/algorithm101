package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.18
 *
 * https://leetcode-cn.com/problems/house-robber
 * https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1]; // dp[k] 表示 前k个房子偷到的最大数
        dp[0] = 0;
        dp[1] = nums[0];

        // 1.偷k-1个屋子，k不偷 dp[k] = dp[k - 1]
        // 2.偷k - 2,k屋子，k- 1不偷 dp[k] = dp[k - 2] + nums[k]
        //   => dp[k] = max(dp[k - 1], dp[k - 2] + nums[k])
        for (int k = 2; k <= nums.length; k++) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k - 1]);
        }
        return dp[nums.length];
    }

}
