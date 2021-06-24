package array;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Avizii
 * @Create : 2021.01.12
 * @CN-URL : https://leetcode-cn.com/problems/two-sum
 * @EN-URL : https://leetcode.com/problems/two-sum
 * @Solve1 :
 * @Solve2 :
 * @Solve3 :
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) return new int[]{i, j};
            }
        }
        return new int[0];
    }

    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer hit = map.get(target - nums[i]);
            if (hit != null) return new int[]{i, hit};
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
