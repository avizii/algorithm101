package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.02.04
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode-solution/
 * https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0]; // 初始化第一个数
        for (int i = 1; i < m; i++) dp[i][0] = grid[i][0] + dp[i - 1][0]; // 初始化第一列
        for (int i = 1; i < n; i++) dp[0][i] = grid[0][i] + dp[0][i - 1]; // 初始化第一行
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
