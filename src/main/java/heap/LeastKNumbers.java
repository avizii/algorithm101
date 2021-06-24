package heap;

import java.util.PriorityQueue;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * @EN-URL : https://leetcode.com/problems/zui-xiao-de-kge-shu-lcof/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
 * @Solve2 :
 * @Solve3 :
 */
public class LeastKNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        // PriorityQueue传入Compartor，前面-后面 为小顶堆，默认Comparator.comparingInt就是前面-后面，反之，后 - 前 为大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1); // 大顶堆
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
