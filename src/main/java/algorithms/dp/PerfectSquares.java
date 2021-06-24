package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.18
 *
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * https://leetcode-cn.com/problems/perfect-squares/solution/279-wan-quan-ping-fang-shu-wan-quan-bei-htyas/
 */
public class PerfectSquares {

    public int numSquares(int n) {
        // 完全背包问题
        // dp[i]  =>  和为i的完全平方数的最少数量
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // 初始化 dp[i] = i ==> 即默认最大情况下为 dp[i] = 1 + 1 + 1 + …… + 1 = i
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                // dp[i] = min(dp[i], dp[i - j * j] + 1)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }


    public int solve2(int n) {
        int[] dp = new int[n + 1];
        for (int i =1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
