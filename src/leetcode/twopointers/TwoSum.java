package leetcode.twopointers;

import java.util.HashMap;

public class TwoSum {
  public int[] twoSum(int[] numbers, int target) {
    int l=0;
    int r=numbers.length-1;

    int sum = numbers[l]+numbers[r];

    while( sum != target ) {
      if( sum > target ) {
        r--;
      } else {
        l++;
      }
      sum = numbers[l]+numbers[r];
    }
    return new int[]{1+l, 1+r};
  }
}
