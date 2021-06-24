package algorithms.recursion;

/**
 * @Author : Avizii
 * @Create : 2021.03.12
 *
 * https://leetcode-cn.com/problems/surrounded-regions
 * https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        // terminal
        if (i < 0 || i >= board.length) return;
        if (j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'X' || board[i][j] == '#') return;

        // process logic
        board[i][j] = '#'; // avoid duplication

        // drill down
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
