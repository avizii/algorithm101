package algorithms.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : Avizii
 * @Create : 2021.03.19
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/shou-hua-tu-jie-zhan-de-xiang-xi-si-lu-by-hyj8/
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        /*
         * dp[i] -> s[i]结尾的最长有效子串长度
         *
         * base case -> dp[0] = 0
         *
         * if s[i] = '(' => dp[i] = 0
         * if s[i] = ')' =>
         *   if s[i - 1] = '(' => dp[i] = dp[i - 2] + 2
         *   if s[i - 1] = ')' =>
         *       if s[i - dp[i - 1] - 1] = ')' or null => dp[i] = 0
         *       if s[i - dp[i - 1] - 1] = '(' =>
         *           if s[i - dp[i - 1] - 2] != null => dp[i] = 2 + dp[i - dp[i - 1] - 2] + dp[i - 1]
         *           if s[i - dp[i - 1] - 2] = null  => dp[i] = 2 + dp[i - 1]
         * */
        int[] dp = new int[s.length()];
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] - 1 >= 0 && arr[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lvp(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }

}
