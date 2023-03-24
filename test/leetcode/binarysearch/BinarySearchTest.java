package leetcode.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BinarySearchTest {

  @Test
  void searchTest( ) {
    BinarySearch o = new BinarySearch();

    Assertions.assertEquals( 4, o.search( new int[] {-1,0,3,5,9,12}, 9 ) );
    Assertions.assertEquals( -1, o.search( new int[] {-1,0,3,5,9,12}, 2 ) );
  }

  @Test
  void matrixTest( ) {
    Search2D o = new Search2D();

    Assertions.assertTrue( o.searchMatrix( new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3 ) );
    Assertions.assertFalse( o.searchMatrix( new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13 ) );
  }

}
