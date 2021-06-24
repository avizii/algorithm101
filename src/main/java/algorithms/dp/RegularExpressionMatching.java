package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.19
 *
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        /*
        * dp[i][j] => s串的前i个字符是否与p串的前j个字符匹配
        *
        * base case:
        *   1.dp[0][0] = true => s、p都为空串, 匹配
        *   2.i >= 1: dp[i][0] = false => p为空串，s不为空串，不匹配
        *   3.dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2] => s为空串，但p不为空串，要想匹配，只可能是右端是星号，它干掉一个字符后，把 p 变为空串
        *
        * dp equation:
        * 1) s[i - 1] = p[j - 1] => dp[i][j] = dp[i - 1][j - 1]
        * 2) p[j - 1] = '.' => dp[i][j] = dp[i - 1][j - 1]
        * 3) p[j - 1] = '*' =>
        *       a) s[i - 1] = p[j - 2] => dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j]
        *               a) 不匹配   p[j - 2] => dp[i][j - 2]
        *               b) 匹配一个 p[j - 2] => dp[i - 1][j - 2]
        *               c) 匹配多个 p[j - 2] => dp[i -1][j]
        *       b) s[i - 1] != p[j - 2] => dp[i][j] = dp[i][j - 2]  将p[j - 1]的*干掉p[j - 2]，即*不匹配 p[j - 2]
        *
        * */

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // for (int i = 1; i < s.length(); i++) dp[i][0] = false;
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
