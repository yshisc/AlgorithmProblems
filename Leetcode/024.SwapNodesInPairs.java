package Leetcode;
/**
 * @author xiangfeidong
 *
 * 24.Swap Nodes in Pairs: Keep a pointer to record each pair's precursive node.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next, node2 = node1.next;
            //pre->node1->node2->...  ==>  pre->node2->node1->...
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            pre = node1;
        }

        return dummy.next;
    }
}
