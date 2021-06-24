package algorithms.bs;

import java.util.Arrays;

/**
 * @Author : Avizii
 * @Create : 2021.03.11
 *
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l < r) {  // TODO 这里是 l < r 而不是 l <= r
            int mid = l + ((r - l) >> 1);
            long cnt = Arrays.stream(nums).filter(n -> n < mid).count();
            if (cnt >= mid) r = mid - 1;
            else l = mid;
        }
        return l;
    }
}
