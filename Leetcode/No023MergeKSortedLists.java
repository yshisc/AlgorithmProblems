package Leetcode;

import Leetcode.common.ListNode;

/**
 * @author xiangfeidong
 *
 * 23.Merge k Sorted Lists
 *
 * Time complexity: Assume totally n nodes.
 *                   K
 *                 /   \       -->   O(n)               \
 *               K/2   K/2                               |
 *               / \    / \    -->   O(x)+O(n-x)=O(n)    |
 *            K/4  K/4 K/4 K/4                           |
 *            ...                                        |  ==>   O(nlogn)
 *           2     ...    2                              |
 *          / \          / \                             |
 *         1   1        1   1                           /
 */
public class No023MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    //Cut lists into two parts and merge the two parts.
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode l1 = mergeKLists(lists, start, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
