package leetcode.arraysandhashing;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArrayAndHashTest {

  ContainsDuplicate obj;
  TopkFrequentElements topk;

  @BeforeAll
  void initilize( ) {
    obj = new ContainsDuplicate();
    topk = new TopkFrequentElements();
  }

  @Nested
  @DisplayName("duplicate test classes")
  class DuplicateTests {

    @Test
    void hasNoElements( ) {
      boolean ok = obj.containsDuplicate( new int[]{} );
      Assertions.assertFalse( ok );
    }

    @Test
    void hasNoMatchedElements( ) {
      boolean ok = obj.containsDuplicate( new int[]{1, 2, 3, 5, 6} );
      Assertions.assertFalse( ok );
    }

    @Test
    void hasSomeMatchedElements( ) {
      boolean ok = obj.containsDuplicate( new int[]{1, 2, 3, 6, 2} );
      Assertions.assertTrue( ok );
    }
  }

  @Test
  void twoSumTest( ) {
    TwoSum o = new TwoSum();

    int[] outVals = o.twoSum( new int[]{2, 7, 11, 15}, 9 );
    Assertions.assertEquals( 2, outVals.length );
    Arrays.sort( outVals );
    Assertions.assertEquals( 0, outVals[ 0 ] );
    Assertions.assertEquals( 1, outVals[ 1 ] );

    outVals = o.twoSum( new int[]{3, 2, 4}, 6 );
    Assertions.assertEquals( 2, outVals.length );
    Arrays.sort( outVals );
    Assertions.assertEquals( 1, outVals[ 0 ] );
    Assertions.assertEquals( 2, outVals[ 1 ] );

    outVals = o.twoSum( new int[]{3, 3}, 6 );
    Assertions.assertEquals( 2, outVals.length );
    Arrays.sort( outVals );
    Assertions.assertEquals( 0, outVals[ 0 ] );
    Assertions.assertEquals( 1, outVals[ 1 ] );
  }

  @Test
  void prodExceptSelfTest( ) {
    ProdOfArrayExceptSelf o = new ProdOfArrayExceptSelf();
    int[] outVals = o.productExceptSelf( new int[]{1, 2, 3, 4} );
    Assertions.assertEquals( 24, outVals[0] );
    Assertions.assertEquals( 12, outVals[1] );
    Assertions.assertEquals( 8, outVals[2] );
    Assertions.assertEquals( 6, outVals[3] );

    o = new ProdOfArrayExceptSelf();
    outVals = o.productExceptSelf( new int[]{-1,1,0,-3,3} );
    Assertions.assertEquals( 0, outVals[0] );
    Assertions.assertEquals( 0, outVals[1] );
    Assertions.assertEquals( 9, outVals[2] );
    Assertions.assertEquals( 0, outVals[3] );
    Assertions.assertEquals( 0, outVals[4] );

  }

  @Test
  void groupAnagramTest( ) {
    GroupAnagram o = new GroupAnagram();

    List<List<String>> outVal = o.groupAnagrams( new String[]{""} );
    Assertions.assertEquals( 1, outVal.size() );
    Assertions.assertEquals( 1, outVal.get(0).size() );
    Assertions.assertEquals( "", outVal.get(0).get(0) );

    outVal = o.groupAnagrams( new String[]{"a"} );
    Assertions.assertEquals( 1, outVal.size() );
    Assertions.assertEquals( 1, outVal.get(0).size() );
    Assertions.assertEquals( "a", outVal.get(0).get(0) );

    outVal = o.groupAnagrams( new String[]{"eat","tea","tan","ate","nat","bat"} );
    Assertions.assertEquals( 3, outVal.size() );
    for( int i=0; i<3; i++) {
      switch( outVal.get(i).size() ) {
        case 1:
          Assertions.assertTrue(outVal.get(i).contains( "bat" ));
          break;
        case 2:
          Assertions.assertTrue(outVal.get(i).contains( "nat" ));
          Assertions.assertTrue(outVal.get(i).contains( "tan" ));
          break;
        case 3:
          Assertions.assertTrue(outVal.get(i).contains( "ate" ));
          Assertions.assertTrue(outVal.get(i).contains( "eat" ));
          Assertions.assertTrue(outVal.get(i).contains( "tea" ));
          break;
      }

    }
  }

  @Test
  void testTopK( ) {
    int[] outVal = topk.topKFrequent( new int[]{1, 1, 1, 2, 2, 3}, 2 );
    Assertions.assertEquals( 2, outVal.length );
    Assertions.assertEquals( 1, outVal[ 0 ] );
    Assertions.assertEquals( 2, outVal[ 1 ] );

    outVal = topk.topKFrequent( new int[]{-1, -1}, 1 );
    Assertions.assertEquals( 1, outVal.length );
    Assertions.assertEquals( -1, outVal[ 0 ] );

    outVal = topk.topKFrequent( new int[]{1, 2}, 2 );
    Assertions.assertEquals( 2, outVal.length );
    Arrays.sort( outVal );
    Assertions.assertEquals( outVal[ 0 ], 1 );
    Assertions.assertEquals( outVal[ 1 ], 2 );

    outVal = topk.topKFrequent(
        new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5,
            6}, 10 );
    Assertions.assertEquals( 10, outVal.length );
    Arrays.sort( outVal );
    Assertions.assertEquals( outVal[ 0 ], 1 );
    Assertions.assertEquals( outVal[ 1 ], 2 );
    Assertions.assertEquals( outVal[ 2 ], 3 );
    Assertions.assertEquals( outVal[ 3 ], 4 );
    Assertions.assertEquals( outVal[ 4 ], 5 );
    Assertions.assertEquals( outVal[ 5 ], 6 );
    Assertions.assertEquals( outVal[ 6 ], 7 );
    Assertions.assertEquals( outVal[ 7 ], 8 );
    Assertions.assertEquals( outVal[ 8 ], 10 );
    Assertions.assertEquals( outVal[ 9 ], 11 );

  }

  @Test
  void anagramTest( ) {
    ValidAnagram o = new ValidAnagram();

    Assertions.assertTrue( o.isAnagram( "anagram", "nagaram" ) );
    Assertions.assertFalse( o.isAnagram( "rat", "car" ) );
  }

  @Test
  void validSudokuTest( ) {
    char[][] board1 =        new char[][] {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
      ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
      ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
      ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
      ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
      ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
      ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
      ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
      ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    char[][] board2 =      new char[][] {
      {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
      ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
      ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
      ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
      ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
      ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
      ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
      ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
      ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    char[][] board3 =      new char[][] {
        {'.','.','4','.','.','.','6','3','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'5','.','.','.','.','.','.','9','.'},
        {'.','.','.','5','6','.','.','.','.'},
        {'4','.','3','.','.','.','.','.','1'},
        {'.','.','.','7','.','.','.','.','.'},
        {'.','.','.','5','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.','.'}};

    ValidSudoku o = new ValidSudoku();

    Assertions.assertTrue( o.isValidSudoku( board1) );
    Assertions.assertFalse( o.isValidSudoku(board2) );
    Assertions.assertFalse( o.isValidSudoku(board3) );
  }
}
