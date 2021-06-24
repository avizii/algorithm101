package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author : Avizii
 * @Create : 2021.03.19
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/fan-zhuan-zi-fu-chuan-li-de-dan-ci-by-leetcode-sol/
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        StringBuilder builder = trim(s);
        reverse(builder, 0, builder.length() - 1);
        reverseWord(builder);
        return builder.toString();
    }

    private void reverseWord(StringBuilder builder) {
        int start = 0, end = 0;
        while (start < builder.length()) {
            while (end < builder.length() && builder.charAt(end) != ' ') {
                end++;
            }
            reverse(builder, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    private void reverse(StringBuilder builder, int l, int r) {
        while (l < r) {
            char c = builder.charAt(l);
            builder.setCharAt(l++, builder.charAt(r));
            builder.setCharAt(r--, c);
        }
    }

    private StringBuilder trim(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') l++;
        while (l <= r && s.charAt(r) == ' ') r--;

        StringBuilder builder = new StringBuilder();
        while (l <= r) {
            char c = s.charAt(l);
            if (c != ' ') builder.append(c);
            else if (builder.charAt(builder.length() - 1) != ' ') builder.append(c);
            l++;
        }
        return builder;
    }

    public String reverseWordsAPI(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
