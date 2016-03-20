package Leetcode;
/**
 * @author xiangfeidong
 *
 * 83.Remove Duplicates from Sorted List
 *
 * Two pointers:
 *      pre -> first node of currently processed value
 *      cur -> last node of currently processed value
 * if pre = cur, there is no duplicate, jsut forward pre.
 * else there exists duplicates, let pre.next=cur.next to remove duplicated nodes, foward pre.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = head, cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre == cur) {
                pre = pre.next;
                cur = pre;
            } else {
                pre.next = cur.next;
                cur = pre;
            }
        }

        return head;
    }
}
