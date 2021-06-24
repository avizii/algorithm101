package algorithms.recursion;

import java.util.*;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/combinations
 *
 * https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (k <= 0 || n < k) return list;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k,1, path, list);
        return list;
    }

    private void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> list) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        // pruning :
        // 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n ; 接下来要选择的元素个数 = k - path.size()
        // int i = start; i <= n - (k - path.size()) + 1; i++
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, start + 1, path, list);
            path.removeLast();
        }
    }

}
