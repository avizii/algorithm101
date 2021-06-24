package array;

/**
 * @Author : Avizii
 * @Create : 2021.03.15
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candNum = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candNum) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candNum = nums[i];
                count = 1;
            }
        }
        return candNum;
    }
}
