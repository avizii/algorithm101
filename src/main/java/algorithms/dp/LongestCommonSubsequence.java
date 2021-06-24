package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.02.02
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/solution/chao-xiang-xi-dong-tai-gui-hua-jie-fa-by-shi-wei-h/
 * https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-zhi-zui-chang-gong-gong-zi-xu-lie/
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray(), s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                dp[i][j] = s1[i - 1] == s2[j - 1] ?
                        dp[i - 1][j - 1] + 1 :  // 末端相同
                        Math.max(dp[i - 1][j], dp[i][j - 1]);  // 末端不同
            }
        }
        return dp[s1.length][s2.length];
    }
}
