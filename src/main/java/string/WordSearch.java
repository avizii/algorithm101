package string;

/**
 * @Tag : DFS、回溯
 * @Author : Avizii
 * @Create : 2021.03.11
 * https://leetcode-cn.com/problems/word-search/
 *
 * https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space. @See xietao0221
 */
public class WordSearch {

    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;  // dfs to search
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // terminal
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return false;
        if (board[i][j] == '#' || board[i][j] != word.charAt(index)) return false;

        boolean res = false;
        char c = board[i][j];
        board[i][j] = '#'; // use '#' to represent this element is visited

        for (int[] dir : dirs) {
            res |= dfs(board, word, i + dir[0], j + dir[1], index + 1);
            if (res) return true; // if find the word, return immediately
        }
        board[i][j] = c; // reverse state / backtracking
        return false;
    }
}
