package stack;

import java.util.Stack;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode.com/problems/trapping-rain-water
 * @EN-URL : https://leetcode.com/problems/trapping-rain-water/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/trapping-rain-water/solution/trapping-rain-water-by-ikaruga/
 * @Solve2 :
 * @Solve3 :
 */
public class TrappingRainWater {

    public int trapDirect(int[] height) {
        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int ml = 0, mr = 0;
            for (int j = i; j > 0; j--) ml = Math.max(ml, height[j]);
            for (int j = i; j < height.length; j++) mr = Math.max(mr, height[j]);
            water += Math.min(ml, mr) - height[i];
        }
        return water;
    }

    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int cur = stack.pop();
                if (stack.isEmpty()) break;
                int l = stack.peek();
                int r = i;
                int h = Math.min(height[r], height[l]) - height[cur];
                water += (r - l - 1) * h;
            }
            stack.push(i);
        }
        return water;
    }
}
