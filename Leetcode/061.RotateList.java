package Leetcode;
/**
 * @author xiangfeidong
 *
 * 61.Rotate List
 *
 * Start from head, step to last node, and link it to head.
 * Then from that node, step length-k%length, and link the node to null
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        //Get list length and link last node to head.
        int length = 1;
        ListNode node = head;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        node.next = head;

        //Find (length-k%length)th node (instead of length-k), which is previous to cutting line.
        //Use (length-k%length)instead of (length-k) to handle cases that k>=length.
        for (int i = 0; i < length - k % length; i++) {
            node = node.next;
        }

        //Link the node to null.
        head = node.next;
        node.next = null;

        return head;
    }
}
