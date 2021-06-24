package linked;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.05  TODO
 * @URL : http://leetcode-cn.com/problems/reverse-linked-list-ii
 * @Solution : https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode then = start.next; // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null, pre = 1, start = 2, then = 3
        for (int i = 0; i < n - m; i++) {
            start.next = then.next; // 2 -> 4                                    // 2 -> 5
            then.next = pre.next;   // 3 -> 2                                    // 4 -> 3
            pre.next = then;        // 1 -> 3  // 1 -> 3 -> 2 -> 4 -> 5          // 1 -> 4  // 1 -> 4 -> 3 -> 2 -> 5
            then = start.next;
            // first reverse : dummy -> 1 -> 3 -> 2 -> 4 -> 5 -> null, pre = 1, start = 2, then = 4
            // second reverse : dummy -> 1 -> 4 -> 3 -> 2 -> 5 -> null, pre = 1, start = 2, then = 5
        }
        return dummy.next;
    }

}
