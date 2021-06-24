package stack;

import java.util.Stack;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * @EN-URL : https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 * @Solve2 : https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
 * @Solve3 :
 */
public class LargestRectangleInHistogram {

    // 1.暴力解法
    // 2.左右夹逼
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int l = i, r = i;
            while (l > 0 && heights[l - 1] >= heights[i]) l--;
            while (r < heights.length - 1 && heights[r + 1] >= heights[i]) r++;
            int width = r - l + 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }
        return maxArea;
    }

    public int largestRectangleAreaStack(int[] arr) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[arr.length + 2];
        System.arraycopy(arr, 0, nums, 1, arr.length);
        // 找到i的左右边界 ； stack中保存index；
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                maxArea = Math.max(maxArea, (r - l - 1) * nums[cur]);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        LargestRectangleInHistogram f = new LargestRectangleInHistogram();
        System.out.println(f.largestRectangleAreaStack(nums));
    }
}
