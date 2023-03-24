package leetcode.linkedlist;

/**
 * This class implements two versions
 * - recursive (reverseList()) and non-recursive (reverseListNotRecursive())
 * - both algorithms were interesting enough to include here, both are O(n)
 * - they both center on isolated each pair and reversing the 1 link between them
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head, head.next);
        head.next = null;
        return newHead;
    }

    private ListNode reverse(ListNode h, ListNode n) {
        ListNode possHead = n;
        if (n.next != null) {
            possHead = reverse(n, n.next);
        }
        n.next = h;
        return possHead;
    }

    public ListNode reverseListNotRecursive(ListNode head) {
        ListNode p = null;
        ListNode q = null;
        ListNode r = head;

        // r is the farthest right node processed, q is prev, p is prev-prev
        // if we have q and r, we need to set q to point to p (null first time)
        // when r is null, after setting q to point to p, q is our new head

        while (r != null) {
            p = q;
            q = r;
            r = r.next; // order is important = need to update r before q (it points to THIS r...)
            q.next = p;
        }
        return q;
    }

    /**
     * Definition for singly-linked list. Given...
     */
    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
