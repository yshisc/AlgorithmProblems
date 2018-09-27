package Leetcode;

import Leetcode.common.ListNode;

/**
 * @author xiangfeidong
 *
 * 2.Add Two Numbers
 *
 */
public class No002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode root = new ListNode(0);
        ListNode node = root;
        
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        
        if (sum >= 10) {
            node.next = new ListNode(1);
        }
        
        return root.next;
    }
}

