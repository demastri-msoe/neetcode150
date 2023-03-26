package leetcode.heappriorityqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeapTest {

  @Test
  public void kthLargestTest() {
    KthLargest o = new KthLargest( 3, new int[] {4,5,8,2} );

    Assertions.assertEquals( 4, o.add(3) );
    Assertions.assertEquals( 5, o.add(5) );
    Assertions.assertEquals( 5, o.add(10) );
    Assertions.assertEquals( 8, o.add(9) );
    Assertions.assertEquals( 8, o.add(4) );
  }

  @Test
  public void stoneWeightTest() {
    LastStone o = new LastStone();

    Assertions.assertEquals( 1, o.lastStoneWeight( new int[] {1} ) );

    Assertions.assertEquals( 1, o.lastStoneWeight( new int[] {2,7,4,1,8,1} ) );
  }

  @Test
  public void kClosestTest() {
    KClosest o = new KClosest();

    // this implementation returns closest first, can test that way
    int [][] outList = o.kClosest( new int[][] {{1,3}, {-2,2}}, 1 );
    Assertions.assertEquals( 1, outList.length );
    Assertions.assertEquals( 2, outList[0].length );
    Assertions.assertEquals( -2, outList[0][0] );
    Assertions.assertEquals( 2, outList[0][1] );

    // this implementation returns closest first, can test that way
    outList = o.kClosest( new int[][] {{3,3}, {5,-1}, {-2,4}}, 2 );
    Assertions.assertEquals( 2, outList.length );
    Assertions.assertEquals( 2, outList[0].length );
    Assertions.assertEquals( 3, outList[0][0] );
    Assertions.assertEquals( 3, outList[0][1] );
    Assertions.assertEquals( -2, outList[1][0] );
    Assertions.assertEquals( 4, outList[1][1] );
  }

}
