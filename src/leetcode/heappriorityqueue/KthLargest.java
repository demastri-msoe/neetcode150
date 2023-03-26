package leetcode.heappriorityqueue;

import java.util.PriorityQueue;

public class KthLargest {
  int k;
  PriorityQueue<Integer> theQueue;
  public KthLargest(int k, int[] nums) {
    this.k = k;
    theQueue = new PriorityQueue<>();
    for( int i: nums)
      add(i);
  }

  public int add(int val) {
    theQueue.add( val );
    while( theQueue.size()>k) {
      theQueue.remove();
    }
    return theQueue.peek();
  }
}
