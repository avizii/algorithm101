package array;

/**
 * @Author : Avizii
 * @Create : 2021.01.12
 * @CN-URL : https://leetcode-cn.com/problems/container-with-most-water
 * @EN-URL : https://leetcode.com/problems/container-with-most-water
 * @Solve1 :
 * @Solve2 :
 * @Solve3 :
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    /**
     * 双指针夹逼，往中间收敛
     * @param height
     * @return
     */
    public int maxAreaDP(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            max = height[i] > height[j] ?
                    Math.max(max, (j - i) * height[j--]) :
                    Math.max(max, (j - i) * height[i++]);
        }
        return max;
    }
}
