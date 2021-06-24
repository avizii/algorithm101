package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Avizii
 * @Create : 2021.03.16
 *
 * https://leetcode-cn.com/problems/n-queens/
 * https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-jing-dian-hui-su-suan-fa-tu-wen-xiang-j/
 * https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
 */
public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(chess, 0, res);
        return res;
    }

    private void solve(char[][] chess, int row, List<List<String>> res) {
        // terminal
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                solve(chess, row + 1, res);
                chess[row][col] = '.';   // backtracking
            }
        }

    }

    private boolean valid(char[][] chess, int row, int col) {
        // 判断上方
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') return false;
        }

        // 判断左斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') return false;
        }

        // 判断右斜线
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] chess) {
        List<String> list = new ArrayList<>();
        for (char[] chars : chess) {
            list.add(new String(chars));
        }
        return list;
    }

}
