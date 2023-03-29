/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/23/2023
 */
package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-list/
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {

    /**
     * this is one of the few I didn't get cleanly, code heavily based on published solution
     * <p>
     * The efficient algorithm uses two pointers to get to the middle of the list - see connents
     * - split the list in half (2 ptrs)
     * - invert the second list in place
     * - assemble the output list from these two
     *
     * the others
     * 1 - have multiple walks of the list at each pass to get the next inserted nodes
     * 2 - build a list from the nodes to more easily reorder the output
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        // this uses 2 pointers to split the list in half
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ok - at this point, fast is at the end of the loop, slow is half way through
        // this code inverts the second half of the list (after slow)
        ListNode second = slow.next;        // first node of the second half
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // ok - at this point, the second half of the list (after slow) is inverted, prev is the top
        // this is the final assembly of the reordered list
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;   // node to be pushed back one
            ListNode tmp2 = second.next;  // next node in the inverted back half list
            first.next = second;          // insert into first list
            second.next = tmp1;           // point to rest of first list
            first = tmp1;                 // reset insertion head as next node of first list
            second = tmp2;                // reset source as new top of second list
        }
    }

    private void inefficient(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode walk = head;
        while (walk != null) {
            ListNode next = getLast(walk);
            if (next == null) {
                return;
            }
            next.next = walk.next;
            walk.next = next;

            walk = walk.next.next;
        }
    }

    private ListNode getLast(ListNode n) {
        if (n.next == null) {
            return null;
        }
        ListNode last = n;
        n = n.next;
        while (n.next != null) {
            last = n;
            n = n.next;
        }
        last.next = null;
        return n;
    }


    private void lessInefficient(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        List<ListNode> nodes = new ArrayList<>();

        ListNode walk = head.next;
        while (walk != null) {
            nodes.add(walk);
            walk = walk.next;
        }
        walk = head;

        int front = 0;
        int back = nodes.size() - 1;

        for (int i = 1; i <= nodes.size(); i++) {
            if ((i % 2) == 1) {
                walk.next = nodes.get(back--);
            } else {
                walk.next = nodes.get(front++);
            }
            walk = walk.next;
        }
        walk.next = null;
    }
}
