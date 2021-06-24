package linked;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.05
 * @URL : http://leetcode-cn.com/problems/rotate-list
 * @Solution : https://leetcode-cn.com/problems/rotate-list/solution/61-xuan-zhuan-lian-biao-tu-wen-xiang-jie-by-sdwwld/
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        int length = 1;
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }
        fast.next = head;
        int step = length - (k % length);
        while (step-- > 1) slow = slow.next;
        ListNode start = slow.next;
        slow.next = null;
        return start;
    }



}
