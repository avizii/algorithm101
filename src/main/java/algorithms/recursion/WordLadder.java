package algorithms.recursion;

import java.util.*;

/**
 * @Author : Avizii
 * @Create : 2021.03.16
 *
 * https://leetcode-cn.com/problems/word-ladder/
 * https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/
 * https://leetcode-cn.com/problems/word-ladder/solution/shou-hua-tu-jie-127-dan-ci-jie-long-bfsde-dian-x-2/
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord); // 保证不出现 aot -> act -> aot 的情况
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (bfs(word, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean bfs(String word, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char origin = chars[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == origin) continue;
                chars[i] = k;
                String nextWord = String.valueOf(chars);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) return true;
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
                chars[i] = origin;
            }
        }
        return false;
    }
}
/*
* public int ladderLength(String begin, String end, List<String> wordList) {
*
*
* }
* */