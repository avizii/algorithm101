package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Tag : Trie、DFS
 * @Author : Avizii
 * @Create : 2021.03.11
 * <p>
 * https://leetcode-cn.com/problems/word-search-ii/
 * <p>
 * https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)   Trie + DFS/Backtracking
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        TrieNode root = buildTire(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, list);
            }
        }
        return list;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> list) {
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) return;  // TODO [c == '#'] 这个判断要在前面，在后面会发生数组越界，因为c = '#'
        node = node.next[c - 'a'];
        if (node.word != null) {
            list.add(node.word);
            node.word = null;  // 清空保证不重复
        }
        board[i][j] = '#';

        if (i > 0) dfs(board, i - 1, j, node, list);
        if (j > 0) dfs(board, i, j - 1, node, list);
        if (i < board.length - 1) dfs(board, i + 1, j, node, list);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, list);
        board[i][j] = c; // reverse
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private TrieNode buildTire(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.next[index] == null) node.next[index] = new TrieNode();
                node = node.next[index];
            }
            node.word = word;
        }
        return root;
    }
}
