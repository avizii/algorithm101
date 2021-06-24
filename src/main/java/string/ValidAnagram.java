package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.04
 * @Problem : https://leetcode-cn.com/problems/valid-anagram/
 * @Solution : https://leetcode.com/problems/valid-anagram/discuss/66484/Accepted-Java-O(n)-solution-in-5-lines
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) alphabet[c - 'a']++;
        for (char c : t.toCharArray()) {
            if (alphabet[c - 'a'] == 0) return false;
            alphabet[c - 'a']--;
        }
        return true;
    }

    public boolean isAnagramUnicode(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int value : map.values()) {
            if (value != 0) return false;
        }
        return true;
    }

}
