package algorithms.dp;

import java.util.List;

/**
 * @Author : Avizii
 * @Create : 2021.02.04
 *
 * https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
 * https://leetcode-cn.com/problems/triangle/solution/san-chong-jie-fa-duo-tu-xiang-jie-120-san-jiao-xin/
 *      -- 看自下而上的图形推导过程
 *
 */
public class Triangle {

    // 自下而上递推
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotalSpace(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }



}
