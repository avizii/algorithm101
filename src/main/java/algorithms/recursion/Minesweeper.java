package algorithms.recursion;

/**
 * @Author : Avizii
 * @Create : 2021.03.16
 * https://leetcode-cn.com/problems/minesweeper
 * https://leetcode-cn.com/problems/minesweeper/solution/cong-qi-dian-kai-shi-dfs-bfs-bian-li-yi-bian-ji-ke/
 */
public class Minesweeper {
    // 8个方向
    int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') { // 起点是雷，直接结束
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        int cnt = 0;  // 判断空地 (i, j) 周围是否有雷，若有，则将该位置修改为雷数，终止该路径的搜索
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= board.length) continue;
            if (y < 0 || y >= board[0].length) continue;
            if (board[x][y] == 'M') cnt++;
        }
        if (cnt > 0) {
            board[i][j] = (char) (cnt + '0');
        } else {
            board[i][j] = 'B';
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= board.length) continue;
                if (y < 0 || y >= board[0].length) continue;
                if (board[x][y] != 'E') continue;
                dfs(board, x, y);
            }
        }
    }

}
