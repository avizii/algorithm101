package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.17
 *
 * https://leetcode-cn.com/problems/maximal-square
 * @solve1: https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
 * @solve2: https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/ 看图片
 * @solve3: https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
 *
 */
public class MaximalSquare {

    /*
     *   dp[i][j] => (i,j)为右下角且只包含1的正方形边长最大值
     *   1.matrix[i][j] = '0' => dp[i][j] = 0
     *   2.matrix[i][j] = '1' =>
     *        a. i = 0 || j = 0 => dp[i][j] = 1
     *        b. min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1  => @See ↑↑↑↑ @Solve2 图片
     * */

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0, row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public int max1(char[][] matrix) {
        int maxSide = 0, row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

}
