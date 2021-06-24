package array;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.12
 * @CN-URL : https://leetcode-cn.com/problems/move-zeroes
 * @EN-URL : https://leetcode.com/problems/move-zeroes
 * @Solve1 :
 * @Solve2 :
 * @Solve3 :
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }
        for (int i = j; i < nums.length; i++) {
            nums[i++] = 0;
        }
    }

    public void moveZeroesOptimize(int[] nums) {
        if (nums.length <= 1) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
