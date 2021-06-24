package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.17
 *
 * https://leetcode-cn.com/problems/palindromic-substrings
 * https://leetcode-cn.com/problems/palindromic-substrings/solution/shou-hua-tu-jie-dong-tai-gui-hua-si-lu-by-hyj8/
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int count = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                }
                boolean headTailEqual = s.charAt(i) == s.charAt(j);
                if (j == i + 1 && headTailEqual) {
                    dp[i][j] = true;
                    count++;
                }
                if (j > i + 1 && headTailEqual && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public int countSubstrings2(String s) {
        int count = 0;
        // dp[i][j] 表示 s[i:j] 是否为回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 1个字符：i == j
        // 2个字符：j = i + 1 && s.charAt(i) == s.charAt(j)
        // 多个字符: j > i + 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]  头尾字符相等、去头去尾字符串为回文子串
        // 为保证计算 dp[i][j] 时 dp[i+1][j-1] 已完成计算，按照列从上到下扫描，而不是常规的按照行从左到右扫描
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                }
                if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
                if (j > i + 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstring3(String s) {
        int count = 0;

        // dp[i][j] 表示 s[i:j] 是否为回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 1个字符：i = j
        // 2个字符：j = i + 1 && s.charAt(i) = s.charAt(j)
        // n个字符：j > i + 1 && s.charAt(i) = s.charAt(j) && dp[i + 1][j - 1]
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (j == i) {
                    dp[i][j] = true;
                    count++;
                }
                if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
                if (j > i + 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
