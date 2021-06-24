package linked;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.05
 * @URL : http://leetcode-cn.com/problems/sort-list
 * @Solution : https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 *
 * 归并排序
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null; // 将链表从中间切开
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left != null ? left : right;
        return dummy.next;
    }

}
