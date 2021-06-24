package linked;

import java.util.Stack;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.05
 * @URL : http://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * @Solution : https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/shuang-zhi-zhen-zhan-di-gui-3chong-jie-jue-fang-sh/
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode front = head, later = head;
        while (k-- > 0) front = front.next;
        while (front != null) {
            front = front.next;
            later = later.next;
        }
        return later;
    }

}
