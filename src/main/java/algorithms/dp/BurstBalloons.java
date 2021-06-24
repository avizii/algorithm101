package algorithms.dp;

import java.util.Arrays;

/**
 * @Author : Avizii
 * @Create : 2021.03.18
 *
 * https://leetcode-cn.com/problems/burst-balloons
 * https://leetcode-cn.com/problems/burst-balloons/solution/zhe-ge-cai-pu-zi-ji-zai-jia-ye-neng-zuo-guan-jian-/
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        System.arraycopy(nums, 0, temp, 1, n);
        temp[0] = 1;
        temp[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];
        for (int i = 3; i <= n + 2; i++) {
            for (int j = 0; j <= n + 2 - i; j++) {
                int res = 0;
                for (int k = j + 1; k < i + j - 1; k++) {
                    int left = dp[j][k];
                    int right = dp[k][i + j - 1];
                    res = Math.max(res, left + temp[j] * temp[k] * temp[i + j - 1] + right);
                }
                dp[j][i + j - 1] = res;
            }
        }
        return dp[0][n + 1];
    }

}
