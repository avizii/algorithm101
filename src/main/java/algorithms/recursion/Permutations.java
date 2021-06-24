package algorithms.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/permutations
 * @EN-URL : https://leetcode.com/problems/permutations/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 * @Solve2 :
 * @Solve3 :
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, nums.length, 0, path, visited, res);
        return res;
    }

    private void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] visited, List<List<Integer>> res) {
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                path.addLast(nums[i]);
                visited[i] = true;
                dfs(nums, length, depth + 1, path, visited, res);
                visited[i] = false;
                path.removeLast();
            }
        }
    }

}
