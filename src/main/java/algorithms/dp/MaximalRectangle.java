package algorithms.dp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author : Avizii
 * @Create : 2021.03.18
 *
 * https://leetcode-cn.com/problems/maximal-rectangle
 * https://leetcode-cn.com/problems/maximal-rectangle/solution/zui-da-ju-xing-by-leetcode-solution-bjlu/  暴力解法
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/solution/maximal-rectangle-by-ikaruga-idh2/   单调栈
 * https://leetcode-cn.com/problems/maximal-rectangle/solution/maximal-rectangle-by-ikaruga-idh2/
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int[][] board = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    board[i][j] = (j == 0 ? 0 : board[i][j - 1]) + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') continue;
                int width = board[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    if (board[k][j] == 0) break;
                    width = Math.min(width, board[k][j]);
                    int height = i - k + 1;
                    area = Math.max(area, width * height);
                }
                res = Math.max(res, area);
            }
        }
        return res;
    }

    public int maximalRectangleByStack(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int[] heights = new int[matrix[0].length + 2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j + 1] = matrix[i][j] == '0' ? 0 : heights[j + 1] + 1;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }

        return res;
    }

    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                maxArea = Math.max(maxArea, (r - l - 1) * heights[cur]);
            }
            stack.push(i);
        }
        return maxArea;
    }

}
