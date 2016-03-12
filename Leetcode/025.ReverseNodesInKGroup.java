package Leetcode;
/**
 * @author xiangfeidong
 *
 * 25. Reverse Nodes in k-Group
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        //Get length of the list.
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        //Create a dummy node and pre pointer.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        //Reverse in k group.
        for (int i = 1; i * k <= len; i++) {
            //Reverse pre->n1->n2->...->nk-> to pre->nk->...->n2->n1->
            cur = pre.next;
            ListNode reHead = null;
            for (int j = 1; j <= k; j++) {
                ListNode next = cur.next;
                cur.next = reHead;
                reHead = cur;
                cur = next;
            }
            pre.next.next = cur;
            ListNode tmp = pre.next;
            pre.next = reHead;
            pre = tmp;
        }

        return dummy.next;
    }
}
