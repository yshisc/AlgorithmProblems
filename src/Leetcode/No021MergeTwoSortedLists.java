package Leetcode;

import Leetcode.common.ListNode;

/**
 * @author xiangfeidong
 *
 * 21.Merge Two Sorted Lists
 */
public class No021MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //Create a dummy head for new list.
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        //Add node with smaller value to new list.
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        //Add the remaining nodes.
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }

        return dummy.next;
    }
}
