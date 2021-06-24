package array;

/**
 * @Author : Avizii
 * @Create : 2021.01.14
 * @CN-URL : https://leetcode-cn.com/problems/rotate-array
 * @EN-URL : https://leetcode.com/problems/rotate-array
 * @Solve1 : https://leetcode-cn.com/problems/rotate-array/solution/javadai-ma-3chong-fang-shi-tu-wen-xiang-q8lz9/
 * @Solve2 : https://leetcode.com/problems/rotate-array/discuss/54289/My-three-way-to-solve-this-problem-the-first-way-is-interesting(JAVA)
 * @Solve3 :
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = temp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
