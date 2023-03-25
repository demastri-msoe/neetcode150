package leetcode.linkedlist;

import org.junit.jupiter.api.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LinkedListTest {

    @Nested
    @DisplayName("linked list reverse tests")
    class ReverseTest {
        @Test
        public void reverseListTestRecursive() {
            ReverseLinkedList o = new ReverseLinkedList();

            ListNode n = null;
            n = o.reverseList(n);
            Assertions.assertNull(n);

            n = new ListNode(2);
            n = new ListNode(1, n);
            n = o.reverseList(n);
            Assertions.assertEquals(2, n.val);
            n = n.next;
            Assertions.assertEquals(1, n.val);
            n = n.next;
            Assertions.assertNull(n);


            n = new ListNode(5);
            n = new ListNode(4, n);
            n = new ListNode(3, n);
            n = new ListNode(2, n);
            n = new ListNode(1, n);
            n = o.reverseList(n);
            Assertions.assertEquals(5, n.val);
            n = n.next;
            Assertions.assertEquals(4, n.val);
            n = n.next;
            Assertions.assertEquals(3, n.val);
            n = n.next;
            Assertions.assertEquals(2, n.val);
            n = n.next;
            Assertions.assertEquals(1, n.val);
            n = n.next;
            Assertions.assertNull(n);
        }
        @Test
        public void reverseListTestNotRecursive() {
            ReverseLinkedList o = new ReverseLinkedList();

            ListNode n = null;
            n = o.reverseListNotRecursive(n);
            Assertions.assertNull(n);

            n = new ListNode(2);
            n = new ListNode(1, n);
            n = o.reverseListNotRecursive(n);
            Assertions.assertEquals(2, n.val);
            n = n.next;
            Assertions.assertEquals(1, n.val);
            n = n.next;
            Assertions.assertNull(n);


            n = new ListNode(5);
            n = new ListNode(4, n);
            n = new ListNode(3, n);
            n = new ListNode(2, n);
            n = new ListNode(1, n);
            n = o.reverseListNotRecursive(n);
            Assertions.assertEquals(5, n.val);
            n = n.next;
            Assertions.assertEquals(4, n.val);
            n = n.next;
            Assertions.assertEquals(3, n.val);
            n = n.next;
            Assertions.assertEquals(2, n.val);
            n = n.next;
            Assertions.assertEquals(1, n.val);
            n = n.next;
            Assertions.assertNull(n);
        }
    }

    @Test
    public void mergeListTest() {
        MergeLists o = new MergeLists();

        ListNode l1 = new ListNode(4);
        l1 = new ListNode(2, l1);
        l1 = new ListNode(1, l1);

        ListNode l2 = new ListNode(4);
        l2 = new ListNode(3, l2);
        l2 = new ListNode(1, l2);

        ListNode outList = o.mergeTwoLists(l1, l2);

        Assertions.assertEquals(1, outList.val);
        outList = outList.next;
        Assertions.assertEquals(1, outList.val);
        outList = outList.next;
        Assertions.assertEquals(2, outList.val);
        outList = outList.next;
        Assertions.assertEquals(3, outList.val);
        outList = outList.next;
        Assertions.assertEquals(4, outList.val);
        outList = outList.next;
        Assertions.assertEquals(4, outList.val);
        Assertions.assertNull(outList.next);

        Assertions.assertNull(o.mergeTwoLists(null, null));

        l2 = new ListNode(0);
        outList = o.mergeTwoLists(null, l2);
        Assertions.assertEquals(0, outList.val);
        Assertions.assertNull(outList.next);
    }

    @Nested
    @DisplayName("linked list cycle tests")
    class CycleTest {
        @Test
        public void cycleTest() {
            FindCycle o = new FindCycle();

            ListNode l1 = new ListNode(-4);
            ListNode tail = l1;
            l1 = new ListNode(0, l1);
            l1 = new ListNode(2, l1);
            ListNode node2 = l1;
            l1 = new ListNode(3, l1);
            tail.next = node2;
            Assertions.assertTrue(o.hasCycle(l1));

            l1 = new ListNode(2);
            node2 = l1;
            l1 = new ListNode(1, l1);
            node2.next = l1;
            Assertions.assertTrue(o.hasCycle(l1));

            l1 = new ListNode(1);
            Assertions.assertFalse(o.hasCycle(l1));

        }
        @Test
        public void cycleTestFixedMemory() {
            FindCycle o = new FindCycle();

            ListNode l1 = new ListNode(-4);
            ListNode tail = l1;
            l1 = new ListNode(0, l1);
            l1 = new ListNode(2, l1);
            ListNode node2 = l1;
            l1 = new ListNode(3, l1);
            tail.next = node2;
            Assertions.assertTrue(o.hasCycleNoMemory(l1));

            l1 = new ListNode(2);
            node2 = l1;
            l1 = new ListNode(1, l1);
            node2.next = l1;
            Assertions.assertTrue(o.hasCycleNoMemory(l1));

            l1 = new ListNode(1);
            Assertions.assertFalse(o.hasCycleNoMemory(l1));

        }
    }
    @Test
    public void reorderTest() {
        ReorderList o = new ReorderList();

        ListNode n;
        n = new ListNode(4);
        n = new ListNode(3, n);
        n = new ListNode(2, n);
        n = new ListNode(1, n);
        o.reorderList( n );
        Assertions.assertEquals( 1, n.val );
        n = n.next;
        Assertions.assertEquals( 4, n.val );
        n = n.next;
        Assertions.assertEquals( 2, n.val );
        n = n.next;
        Assertions.assertEquals( 3, n.val );
        Assertions.assertNull( n.next );

        n = new ListNode(5);
        n = new ListNode(4, n);
        n = new ListNode(3, n);
        n = new ListNode(2, n);
        n = new ListNode(1, n);
        o.reorderList( n );
        Assertions.assertEquals( 1, n.val );
        n = n.next;
        Assertions.assertEquals( 5, n.val );
        n = n.next;
        Assertions.assertEquals( 2, n.val );
        n = n.next;
        Assertions.assertEquals( 4, n.val );
        n = n.next;
        Assertions.assertEquals( 3, n.val );
        Assertions.assertNull( n.next );
    }
}
