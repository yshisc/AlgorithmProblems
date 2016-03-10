package Leetcode;
/**
 * @author xiangfeidong
 *
 * 19.Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Keep a dummy node in case we remove head.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //Compute length.
        int length = 0;
        ListNode cur = dummy;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }

        //Find the node before nth node.
        cur = dummy;
        for (int i = 1; i <= length - n; i++) {
            cur = cur.next;
        }

        //Remove nth node.
        cur.next = cur.next.next;

        return dummy.next;
    }
}
