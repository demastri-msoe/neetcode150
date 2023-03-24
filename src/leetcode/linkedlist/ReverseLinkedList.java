package leetcode.linkedlist;

public class ReverseLinkedList {

  /**
   * Definition for singly-linked list. Given...
   */
  public static class ListNode {

    int val;
    ListNode next;

    ListNode( ) {
    }

    ListNode( int val ) {
      this.val = val;
    }

    ListNode( int val, ListNode next ) {
      this.val = val;
      this.next = next;
    }
  }

    public ListNode reverseList( ListNode head ) {
      if ( head == null || head.next == null ) {
        return head;
      }
      return reverse( head, head.next );
    }

    private ListNode reverse( ListNode h, ListNode n ) {
      ListNode possHead = n;
      if ( n.next != null ) {
        possHead = reverse( n, n.next );
      } else {
        h.next = null;
      }
      n.next = h;
      return possHead;
    }
}
