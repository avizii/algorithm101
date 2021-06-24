package string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/group-anagrams
 * @EN-URL : https://leetcode.com/problems/group-anagrams/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/group-anagrams/solution/kan-wo-yi-ju-hua-ac-zi-mu-yi-wei-ci-fen-yrnis/
 * @Solve2 :
 * @Solve3 :
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }

    public List<List<String>> groupAnagramsStream(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str ->
                        str.chars()
                            .sorted()
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                ).values());
    }

    public List<List<String>> groupAnagramsCount(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    int[] counter = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        counter[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        // 这里的 if 是可省略的，但是加上 if 以后，生成的 sb 更短，后续 groupingBy 会更快。
                        if (counter[i] != 0) {
                            sb.append((char) ('a' + i));
                            sb.append(counter[i]);
                        }
                    }
                    return sb.toString();
                })).values());
    }
}
