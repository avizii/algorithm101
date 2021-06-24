package algorithms.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author : Avizii
 * @Create : 2021.03.15
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(0, nums, stack, res);
        return res;
    }

    private void dfs(int i, int[] nums, Deque<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int j = i; j < nums.length; j++) {
            stack.addLast(nums[j]);
            dfs(j + 1, nums, stack, res);
            stack.removeLast();
        }
    }
}
