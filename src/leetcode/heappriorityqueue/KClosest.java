package leetcode.heappriorityqueue;

import java.util.PriorityQueue;

public class KClosest {
  public int[][] kClosest(int[][] points, int k) {
    // if we compare based just on distance, the smallest are at front...
    PriorityQueue<int[]> theQueue = new PriorityQueue<>(
        (a,b) -> Integer.compare( a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1]) );

    for( int [] p: points ) {
      theQueue.add(p);
      // don't need to remove...
      //while( theQueue.size() > k )
      //  theQueue.remove();
    }
    int [][] outSet = new int[k][2];
    for( int i=0; i<k; i++) {
      int[] pt = theQueue.poll();
      outSet[i][0] = pt[0];
      outSet[i][1] = pt[1];
    }
    return outSet;
  }

}
