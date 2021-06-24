package array;

import java.util.*;

/**
 * @Author : Avizii
 * @Create : 2021.01.12
 * @CN-URL : https://leetcode-cn.com/problems/3sum
 * @EN-URL : https://leetcode.com/problems/3sum
 * @Solve1 :
 * @Solve2 :https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * @Solve3 :
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k] == 0)) list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return new ArrayList<>(list);
    }

    /**
     * 先遍历一遍数组，将不重复的值记录到哈希表中。把问题从a+b+c=0转换成a+b=-c
     * 排序原数组，为方便重复元素直接跳过，优化遍历速度
     * 双重遍历寻找a+b的值是否存在于哈希表中
     * 最后结果需要去重
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumHash(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                Integer val = - nums[i] - nums[j];
                if (set.contains(val)) {
                    list.add(Arrays.asList(nums[i], nums[j], val));
                    while ((j + 1) < nums.length && nums[j] == nums[j+1]) j++;
                } else set.add(nums[j]);
            }
            set.clear();
        }
        return list;
    }

    public List<List<Integer>> threeSumSortDP(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return list;
    }

}
