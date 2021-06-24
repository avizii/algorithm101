package string;

/**
 * @Author : Avizii
 * @Create : 2021.03.19
 */
public class StringSimpleQuestionSet {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder builder = new StringBuilder();

        int length = Integer.MAX_VALUE;
        for (String str : strs) {
            length = Math.min(length, str.length());
        }

        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) return builder.toString();
            }
            builder.append(c);
        }

        return builder.toString();
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (l < r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        StringSimpleQuestionSet s = new StringSimpleQuestionSet();
        s.isPalindrome("A man, a plan, a canal: Panama");
    }
}
