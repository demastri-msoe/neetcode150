package leetcode.heappriorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone {

  public int lastStoneWeight( int[] stones ) {
    PriorityQueue<Integer> theQueue = new PriorityQueue<>( Collections.reverseOrder() );

    for( int i: stones ) {
      theQueue.add( i );
    }

    while( theQueue.size()>1 ) {
      int s1 = theQueue.remove();
      int s2 = theQueue.remove();
      if( s1 != s2)
        theQueue.add( (s1>s2) ? s1-s2 : s2-s1 );
    }

    return theQueue.size() == 0 ? 0 : theQueue.remove();
  }
}