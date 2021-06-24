package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.19
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        // dp[i][j] => s[i:j]是否为回文子串
        // 1: i = j
        // 2: j = i + 1 & s[i] = s[j]
        // n: j > n + 1 & s[i] = s[j] & dp[i+1][j-1]
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, size = 1;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                }
                if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
                if (j > i + 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && j - i + 1 > size) {
                    start = i;
                    size = j - i + 1;
                }
            }
        }
        return s.substring(start, start + size);
    }

    public String bf(String s) {
        int start = 0, size = 1;
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > size && validPalindrome(arr, i, j)) {
                    start = i;
                    size = j - i + 1;
                }
            }
        }
        return s.substring(start, start + size);
    }

    private boolean validPalindrome(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
