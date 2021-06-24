package algorithms.bs;

/**
 * @Author : Avizii
 * @Create : 2021.01.21
 * @CN-URL : https://leetcode-cn.com/problems/search-a-2d-matrix
 * @EN-URL : https://leetcode.com/problems/search-a-2d-matrix/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/search-a-2d-matrix/solution/yi-wen-dai-ni-gao-ding-duo-ge-er-fen-cha-2hl9/
 * @Solve2 : https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode/
 * @Solve3 :
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchA2dMatrix {

    public boolean searchMetrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int value = matrix[mid / n][mid % n];
            if (target == value) return true;
            if (target < value) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }

    // https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/ 解法一
    // 按行二分查找 + 剪枝
    public boolean searchMetrix2(int[][] matrix, int target) {
        int n = matrix[0].length;
        for (int[] row : matrix) {
            if (row[0] > target) break;
            if (row[n - 1] < target) continue;
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                int value = row[mid];
                if (target == value) return true;
                if (target < value) r = mid - 1;
                else l = mid + 1;
            }
        }
        return false;
    }

    // https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/ 方法四
    // 矩阵特性游走：大于向上游走，小于向右游走
    public boolean searchMetrix2_2(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) row--;
            else if (matrix[row][col] < target) col++;
            else return true;
        }
        return false;
    }

}
