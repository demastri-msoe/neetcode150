package leetcode.mathandgeometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathTests {

  @Test
  void rotateTest( ) {
    RotateImage o = new RotateImage();

    int[][] board1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    o.rotate( board1 );
    Assertions.assertEquals( 7, board1[ 0 ][ 0 ] );
    Assertions.assertEquals( 4, board1[ 0 ][ 1 ] );
    Assertions.assertEquals( 1, board1[ 0 ][ 2 ] );
    Assertions.assertEquals( 8, board1[ 1 ][ 0 ] );
    Assertions.assertEquals( 5, board1[ 1 ][ 1 ] );
    Assertions.assertEquals( 2, board1[ 1 ][ 2 ] );
    Assertions.assertEquals( 9, board1[ 2 ][ 0 ] );
    Assertions.assertEquals( 6, board1[ 2 ][ 1 ] );
    Assertions.assertEquals( 3, board1[ 2 ][ 2 ] );

    int[][] board2 = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
    o.rotate( board2 );
    Assertions.assertEquals( 15, board2[ 0 ][ 0 ] );
    Assertions.assertEquals( 13, board2[ 0 ][ 1 ] );
    Assertions.assertEquals( 2, board2[ 0 ][ 2 ] );
    Assertions.assertEquals( 5, board2[ 0 ][ 3 ] );
    Assertions.assertEquals( 14, board2[ 1 ][ 0 ] );
    Assertions.assertEquals( 3, board2[ 1 ][ 1 ] );
    Assertions.assertEquals( 4, board2[ 1 ][ 2 ] );
    Assertions.assertEquals( 1, board2[ 1 ][ 3 ] );
    Assertions.assertEquals( 12, board2[ 2 ][ 0 ] );
    Assertions.assertEquals( 6, board2[ 2 ][ 1 ] );
    Assertions.assertEquals( 8, board2[ 2 ][ 2 ] );
    Assertions.assertEquals( 9, board2[ 2 ][ 3 ] );
    Assertions.assertEquals( 16, board2[ 3 ][ 0 ] );
    Assertions.assertEquals( 7, board2[ 3 ][ 1 ] );
    Assertions.assertEquals( 10, board2[ 3 ][ 2 ] );
    Assertions.assertEquals( 11, board2[ 3 ][ 3 ] );
  }

  @Test
  void plusOneTest() {
    PlusOne o = new PlusOne();

    int [] outVals = o.plusOne( new int[] {1, 2, 3} );
    Assertions.assertEquals( 3, outVals.length );
    Assertions.assertEquals( 1, outVals[0] );
    Assertions.assertEquals( 2, outVals[1] );
    Assertions.assertEquals( 4, outVals[2] );

    outVals = o.plusOne( new int[] {4,3,2,1} );
    Assertions.assertEquals( 4, outVals.length );
    Assertions.assertEquals( 4, outVals[0] );
    Assertions.assertEquals( 3, outVals[1] );
    Assertions.assertEquals( 2, outVals[2] );
    Assertions.assertEquals( 2, outVals[3] );

    outVals = o.plusOne( new int[] {9} );
    Assertions.assertEquals( 2, outVals.length );
    Assertions.assertEquals( 1, outVals[0] );
    Assertions.assertEquals( 0, outVals[1] );
  }

  @Test
  void isHappy() {
    HappyNumber o = new HappyNumber();

    Assertions.assertTrue( o.isHappy( 19 ) );
    Assertions.assertFalse( o.isHappy( 2 ) );

  }

  @Test
  void setMatrixZeroTest() {
    MatrixZeroes o = new MatrixZeroes();

    int [][] board1 = new int[][] {{1,1,1},{1,0,1},{1,1,1}};

    o.setZeroes( board1 );
    Assertions.assertFalse( true );

  }
}
