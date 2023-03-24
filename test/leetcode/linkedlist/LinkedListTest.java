package leetcode.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LinkedListTest {

  @Test
  public void reverseListTest() {
    ReverseLinkedList o = new ReverseLinkedList();

    ReverseLinkedList.ListNode n = null;
    n = o.reverseList( n );
    Assertions.assertNull( n );

    n = new ReverseLinkedList.ListNode(2);
    n = new ReverseLinkedList.ListNode(1, n);
    n = o.reverseList( n );
    Assertions.assertEquals( 2, n.val );
    n = n.next;
    Assertions.assertEquals( 1, n.val );
    n = n.next;
    Assertions.assertNull( n );


    n = new ReverseLinkedList.ListNode(5);
    n = new ReverseLinkedList.ListNode(4, n);
    n = new ReverseLinkedList.ListNode(3, n);
    n = new ReverseLinkedList.ListNode(2, n);
    n = new ReverseLinkedList.ListNode(1, n);
    n = o.reverseList( n );
    Assertions.assertEquals( 5, n.val );
    n = n.next;
    Assertions.assertEquals( 4, n.val );
    n = n.next;
    Assertions.assertEquals( 3, n.val );
    n = n.next;
    Assertions.assertEquals( 2, n.val );
    n = n.next;
    Assertions.assertEquals( 1, n.val );
    n = n.next;
    Assertions.assertNull( n );
  }

}
