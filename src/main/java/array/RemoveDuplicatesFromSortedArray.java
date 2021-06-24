package array;

/**
 * @Author : Avizii
 * @Create : 2021.01.14
 * @CN-URL : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * @EN-URL : https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * @Solve1 :
 * @Solve2 :
 * @Solve3 :
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return j + 1;
    }

}
