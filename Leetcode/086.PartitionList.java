package Leetcode;
/**
 * @author xiangfeidong
 *
 * 86.Partition List
 *
 * Keep two dummy node to be head of two part, traverse list and link every node to relative part.
 * Link the two part.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), p1 = dummy1;
        ListNode dummy2 = new ListNode(0), p2 = dummy2;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                p1.next = cur;
                p1 = p1.next;
            } else {
                p2.next = cur;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        p1.next = dummy2.next;
        p2.next = null;

        return dummy1.next;
    }
}
