package algorithms.dp;

import java.util.Arrays;

/**
 * @Author : Avizii
 * @Create : 2021.02.05
 * @CN-URL : https://leetcode-cn.com/problems/coin-change
 * @EN-URL : https://leetcode.com/problems/coin-change/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * @Solve2 : https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/
 * @Solve3 :
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int upperLimit = amount + 1;
        Arrays.fill(dp, upperLimit);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != upperLimit) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == upperLimit ? -1 : dp[amount];
    }

    /*
    11  {2, 5, 3}
    dp[11] = min(dp[9] + 1, dp[6] + 1, dp[8] + 1)

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int upperLimit = amount + 1;
        Arrays.fill(dp, upperLimit);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != upperLimit) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == upperLimit ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int upperLimit = amount + 1;
        Arrays.fill(dp, upperLimit);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != upperLimit) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == upperLimit ? -1 : dp[amount];
    }
     */

    /*贪心算法+dfs*/
    int minCount = Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        minCoin(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private void minCoin(int[] coins, int amount, int count, int index) {
        if (index < 0 || count + amount / coins[index] >= minCount) return;
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        // 考虑到有 [1,7,10] 这种用例，按照贪心思路 10 + 1 + 1 + 1 + 1 会比 7 + 7 更早找到
        // 所以下面用i-- 继续遍历，每次减少1个最大硬币，再看所需硬币数
        for (int i = amount / coins[index]; i >= 0; i--) {
            minCoin(coins, amount - i * coins[index], count + i, index - 1);
        }
    }

}
