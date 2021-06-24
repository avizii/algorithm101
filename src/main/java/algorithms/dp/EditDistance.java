package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.02.03
 *
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * https://leetcode-cn.com/problems/edit-distance/solution/dong-tai-gui-hua-java-by-liweiwei1419/
 *
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray(), s2 = word2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 0; i <= s1.length; i++) dp[i][0] = i;
        for (int i = 0; i <= s2.length; i++) dp[0][i] = i;

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) { // 相等时
                    dp[i][j] = dp[i - 1][j - 1];
                } else {    // 不等时
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}
