package Leetcode;

import Leetcode.common.ListNode;

/**
 * @author xiangfeidong
 *
 * 92.Reverse Linked List II
 */
public class No092ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //Find (m-1)th node.
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        //Reverse nodes.
        ListNode cur = pre.next;
        ListNode reHead = null;
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = reHead;
            reHead = cur;
            cur = next;
        }

        //Link the 3 parts.
        pre.next.next = cur;
        pre.next = reHead;

        return dummy.next;
    }
}
