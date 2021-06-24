package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.02.01
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/solution/63-bu-tong-lu-jing-iidong-tai-gui-hua-ji-6h8h/
 * https://leetcode-cn.com/problems/unique-paths-ii/solution/jian-dan-dpbi-xu-miao-dong-by-sweetiee/
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue; //equal to `dp[i][j] = 0`;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
