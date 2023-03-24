package leetcode.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TwoPointersTest {

  @Test
  void PalindromeTest() {
    Palindrome o = new Palindrome();

    Assertions.assertTrue( o.isPalindrome( "A man, a plan, a canal: Panama" ) );
    Assertions.assertFalse( o.isPalindrome( "race a car" ) );
    Assertions.assertTrue( o.isPalindrome( "" ) );
    Assertions.assertTrue( o.isPalindrome( " " ) );
    Assertions.assertFalse( o.isPalindrome( "0P" ) );
  }
  @Test
  void twoSumTest() {
    TwoSum o = new TwoSum();

    int [] outVals = o.twoSum( new int[] {2,7,11,15}, 9 );
    Assertions.assertEquals( 2, outVals.length );
    Assertions.assertEquals( 1, outVals[0] );
    Assertions.assertEquals( 2, outVals[1] );

    outVals = o.twoSum( new int[] {2,3,4}, 6);
    Assertions.assertEquals( 2, outVals.length );
    Assertions.assertEquals( 1, outVals[0] );
    Assertions.assertEquals( 3, outVals[1] );

    outVals = o.twoSum( new int[] {-1,0}, -1);
    Assertions.assertEquals( 2, outVals.length );
    Assertions.assertEquals( 1, outVals[0] );
    Assertions.assertEquals( 2, outVals[1] );
  }
}
