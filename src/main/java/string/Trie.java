package string;

/**
 * @Author : Avizii
 * @Create : 2021.03.11
 */
public class Trie {

    private final Trie[] next;
    private boolean isEnd;

    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) return;
        Trie node = this;
        char[] words = word.toCharArray();
        for (char c : words) {
            int n = c - 'a';
            if (node.next[n] == null) node.next[n] = new Trie();
            node = node.next[n];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        char[] words = prefix.toCharArray();
        for (char word : words) {
            node = node.next[word - 'a'];
            if (node == null) return null;
        }
        return node;
    }

}
