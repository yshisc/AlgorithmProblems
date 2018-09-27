package Leetcode;

import Leetcode.common.ListNode;

/**
 * @author xiangfeidong
 *
 * 82.Remove Duplicates from Sorted List II
 *
 * Two pointers:
 *      pre -> previous precessed node
 *      cur -> currently processed ndoe, go to last node with same value
 * if pre.next = cur, there is no duplicate, jsut forward pre and cur.
 * else there exists duplicates, let pre.next=cur.next to remove duplicated nodes, foward cur.
 */
public class No082RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
                cur = cur.next;
            } else {
                pre.next = cur.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
