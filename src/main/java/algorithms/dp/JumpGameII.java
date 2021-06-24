package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.17
 *
 * https://leetcode-cn.com/problems/jump-game-ii
 * https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int end = 0, max = 0, step = 0; // end 当前跳跃点的边界，过了边界需更新，step+1
        for (int i = 0; i < nums.length - 1; i++) {
            // 找到当前跳跃点可达的，能跳到最远的点
            max = Math.max(max, nums[i] + i);
            if (i == end) { // 遇到end边界，更新end边界，step+1
                end = max;
                step++;
            }
        }
        return step;
    }

}
