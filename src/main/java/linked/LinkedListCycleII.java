package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.05
 * @URL : https://leetcode.com/problems/linked-list-cycle-ii
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) return head;
            nodes.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycleDoublePointer(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }
}
