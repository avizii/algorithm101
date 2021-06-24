package stack;

import java.util.LinkedList;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/sliding-window-maximum
 * @EN-URL : https://leetcode.com/problems/sliding-window-maximum/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://blog.csdn.net/zangdaiyang1991/article/details/91904596?utm_medium=distribute.pc_relevant.none-task-blog-searchFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-searchFromBaidu-1.control
 * @Solve2 :
 * @Solve3 :
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) return new int[0];
        int size = nums.length - k + 1;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    public int[] maxSlidingWindowQueue(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) return new int[0];
        int size = nums.length - k + 1;
        int[] res = new int[size];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) queue.pollLast();
            if (!queue.isEmpty() && i - queue.peekFirst() + 1 > k) queue.pollFirst();
            queue.offerLast(i);
            if (i + 1 >= k) res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }

}
