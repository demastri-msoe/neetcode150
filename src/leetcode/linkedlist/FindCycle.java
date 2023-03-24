package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * This class implements two versions
 * - one uses a Set (reverseList()) one does not (reverseListNotMemory())
 * - outside of the overhead to setup the Set, was surprised that the second
 * - looks significantly faster than the first...
 *
 * - did not understand why this algorithm is guaranteed to work at first:
 * - when the "slow" pointer enters the looping section, the "fast" pointer will already be in it
 * - fast will be some amount ahead of the slow pointer.  on every iteration, the fast pointer will
 * - move 2, the slow will move 1, effectively making it 1 further away from the slow pointer.  At
 * - some point (before the slow pointer makes it back around...) that difference will increase
 * - to be the loop size.  Since it's a circular path, this means they will point to the same loc.
 * -
 * - Ta daaaa.
 */
public class FindCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();

        while (head != null) {
            if (!nodes.add(head))
                return true;
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleNoMemory(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
