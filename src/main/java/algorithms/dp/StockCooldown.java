package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.17
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
 */
public class StockCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);  // i - 1天持有  / i天买入 -> i - 1天不持有且不是冷冻期
            dp[i][1] = dp[i - 1][0] + prices[i]; // i - 1天持有，第i天卖出
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]); // i - 1天不持有，且不是冷冻期 / i - 1天不持有，且是冷冻期
        }

        return Math.max(dp[n - 1][1], dp[n - 1][2]); // dp[n - 1][0] 是还持有股票，不用去比较
    }

}
