package heap;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/top-k-frequent-elements
 * @EN-URL : https://leetcode.com/problems/top-k-frequent-elements/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/top-k-frequent-elements/solution/4-chong-fang-fa-miao-sha-topkji-shu-pai-xu-kuai-pa/
 * @Solve2 :
 * @Solve3 :
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = IntStream.of(nums)
                .boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));  // 小顶堆
        map.forEach((num, cnt) -> {
            if (queue.size() < k) queue.offer(num);
            else if (map.get(queue.peek()) < cnt) {
                queue.poll();
                queue.offer(num);
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < queue.size(); i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
