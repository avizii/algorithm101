package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.02.01
 * https://leetcode-cn.com/problems/climbing-stairs/solution/70-pa-lou-ti-dong-tai-gui-hua-jing-dian-a3na7/
 * https://leetcode-cn.com/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
 * https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        // dp[i] = dp[i - 1] + dp[i - 2]
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        int i = 0, j = 0, k = 1;
        for (int l = 1; l <= n; l++) {
            i = j;
            j = k;
            k = i + j;
        }
        return k;
    }
}
