package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Avizii
 * @Create : 2020.12.21
 * @Problem : https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate("", n, n, list);
        return list;
    }

    private void generate(String currentStr, int left, int right, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(currentStr);
            return;
        }
        if (left > right) return; // 剪枝操作
        if (left > 0) generate(currentStr + '(', left - 1, right, list);
        if (right > 0) generate(currentStr + ')', left, right - 1, list);
    }

}
