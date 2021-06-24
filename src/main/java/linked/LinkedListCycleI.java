package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.05
 * @URL : https://leetcode-cn.com/problems/linked-list-cycle
 */
public class LinkedListCycleI {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) return true;
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleDoublePointer(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

}
