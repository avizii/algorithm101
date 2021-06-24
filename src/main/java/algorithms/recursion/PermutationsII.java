package algorithms.recursion;

import java.util.*;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/permutations-ii
 * @EN-URL : https://leetcode.com/problems/permutations-ii/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 :
 * @Solve2 :
 * @Solve3 :
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, nums.length, 0, visited, path, res);
        return res;
    }

    private void dfs(int[] nums, int length, int depth, boolean[] visited, Deque<Integer> path, List<List<Integer>> res) {
        if (length == depth) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (visited[i]) continue;
            // visited[i - 1] == false/!visited[i - 1] 是限制nums[i] == nums[i - 1]的剪枝条件，确保是1已遍历，1'要剪枝的情况
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            path.addLast(nums[i]);
            visited[i] = true;
            dfs(nums, length, depth + 1, visited, path, res);
            visited[i] = false;
            path.removeLast();
        }
    }

}
