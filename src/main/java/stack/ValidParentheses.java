package stack;

import java.util.*;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/valid-parentheses
 * @EN-URL : https://leetcode.com/problems/valid-parentheses/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 :
 * @Solve2 :
 * @Solve3 :
 */
public class ValidParentheses {

    // 暴力解法：一直replace匹配的括号对

    public boolean isValid(String s) {
        if (s.isEmpty() || s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !map.get(c).equals(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s.isEmpty() || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
