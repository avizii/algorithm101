package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.19
 *
 * https://leetcode-cn.com/problems/wildcard-matching/
 *
 * https://leetcode-cn.com/problems/wildcard-matching/solution/shou-hua-tu-jie-dong-tai-gui-hua-de-si-lu-by-hyj8/v
 *
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        // 后往前推
        // dp[i][j] => s串的前i个字符是否和p串的前j个字符匹配
        //
        // base case:
        //      dp[0][0] = true;
        //      dp[0][j] = p[j - 1] == '*' && dp[0][j - 1];
        //      if i >= 1 then dp[i][0] = false;
        //
        // 状态转移方程：
        // 1.s[i - 1] = p[j - 1] => dp[i][j] = dp[i - 1][j - 1]
        // 2.p[j - 1] = '?' => dp[i][j] = dp[i - 1][j - 1]
        // 3.p[j - 1] = '*' => dp[i][j] = dp[i - 1][j] || dp[i][j - 1]
        //      => 匹配多个    dp[i - 1][j]
        //      => 匹配空串''  dp[i][j - 1]

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // for (int i = 1; i < s.length(); i++) dp[i][0] = false;
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        WildcardMatching m = new WildcardMatching();
        System.out.println(m.isMatch("aa", "*"));
    }

}
