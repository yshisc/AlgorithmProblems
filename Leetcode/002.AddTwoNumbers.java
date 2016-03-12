package Leetcode;
/**
 * @author xiangfeidong
 *
 * 2.Add Two Numbers
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Create a dummy head and a pointer of result list.
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        int carry = 0;

        //Keep a pointer for each list.
        ListNode node1 = l1, node2 = l2;

        while (node1 != null || node2 != null) {
            //Calculate sum of current digit.
            int sum = carry;
            if (node1 != null) {
                sum += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.val;
                node2 = node2.next;
            }

            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            carry = sum / 10;
        }

        //Maybe we need an additional digit
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}