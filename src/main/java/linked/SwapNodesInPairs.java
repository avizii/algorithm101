package linked;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.05
 * @URL : https://leetcode.com/problems/swap-nodes-in-pairs
 * @Solution : https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode guard = new ListNode(0); // 定义哨兵节点
        guard.next = head; // 将哨兵节点加在链表的头部
        ListNode cursor = guard; // 定义cursor指针，位于每次要交换的两个节点之前
        while (cursor.next != null && cursor.next.next != null) {
            ListNode start = cursor.next; // 被交换的前节点
            ListNode end = cursor.next.next; // 被交换的后节点
            cursor.next = end; //  cursor -> end
            start.next = end.next; //  start -> end_next
            end.next = start; // end -> start
            cursor = start; // 将cursor指针移动到下次交换的两个节点之前
        }
        return guard.next;
    }

    public ListNode swapPairsIterator(ListNode head) {
        if (head == null || head.next == null) return head;  // terminator
        ListNode next = head.next; // 找到本次要交换的后节点
        head.next = swapPairsIterator(next.next); // head -> next_
        next.next = head; // 后节点 -> head
        return next;
    }

}
