package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Avizii
 * @Create : 2021.03.15
 */
public class PhoneNumberLetterCombination {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if ("".equals(digits)) return res;
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(0, digits, new StringBuilder(), res, letters);
        return res;
    }

    // 通过StringBuilder提高性能，要注意回溯清空状态
    private void dfs(int i, String digits, StringBuilder builder, List<String> res, String[] letters) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        String letter = letters[digits.charAt(i) - '0'];
        for (char c : letter.toCharArray()) {
            dfs(i + 1, digits, builder.append(c), res, letters);
            builder.deleteCharAt(builder.length() - 1);  // backtracking
        }
    }
}
