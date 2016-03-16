package Leetcode;
/**
 * @author xiangfeidong
 *
 * 83.Remove Duplicates from Sorted List
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //i points to first node with value that we are processing.
        //j goes to next to find first node without current value.
        ListNode i = head, j = head.next;
        while (j != null) {
            if (j.val == i.val) {
                j = j.next;
            } else {
                i.next = j;
                i = i.next;
                j = j.next;
            }
        }
        i.next = null;

        return head;
    }
}
