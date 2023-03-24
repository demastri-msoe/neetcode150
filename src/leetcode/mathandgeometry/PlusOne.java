package leetcode.mathandgeometry;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    int carry = 0;
    int incr = 1;
    int[] outArray = new int[digits.length];
    for( int i=digits.length-1; i>=0; i--) {
      int sum = digits[i]+carry+incr;
      outArray[i] = sum%10;
      carry = sum/10;
      incr = 0;
    }
    if( carry == 1) {
      outArray = new int[digits.length+1];
      outArray[0] = 1;
    }
    return outArray;
  }
}
