package leetcode.arraysandhashinng;

public class ProdOfArrayExceptSelf {
  // can't use division
  public int[] productExceptSelf(int[] nums) {
    int[] leftProd = new int[nums.length];
    int lprod = 1;
    for( int i=0; i<nums.length; i++) {
      leftProd[i] = lprod;
      lprod *= nums[i];
    }
    int[] rightProd = new int[nums.length];
    int rprod = 1;
    for( int i=nums.length-1; i>=0; i--) {
      rightProd[i] = rprod;
      rprod *= nums[i];
    }
    int[] outVals = new int[nums.length];
    for( int i=0; i<nums.length; i++) {
      outVals[i] = leftProd[i]*rightProd[i];
    }
    return outVals;
  }
}
