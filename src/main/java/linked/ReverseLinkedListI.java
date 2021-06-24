package linked;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.05
 * @URL : http://leetcode-cn.com/problems/reverse-linked-list
 * @Solution : https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 */
public class ReverseLinkedListI {

    public ListNode reverseList(ListNode head) {
        ListNode cursor = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = cursor;
            cursor = head;
            head = node;
        }
        return cursor;
    }

    public ListNode reverseListIterator(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cursor = reverseListIterator(head.next);
        head.next.next = head;
        head.next = null;
        return cursor;
    }
}
