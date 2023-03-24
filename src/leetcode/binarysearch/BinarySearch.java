package leetcode.binarysearch;

public class BinarySearch {
  public int search(int[] nums, int target) {
    int lowLim = 0;
    int highLim = nums.length;
    int probe = nums.length/2;

    while(nums[probe] != target) {
      if( nums[probe] > target) {
        highLim = probe;
      } else {
        lowLim = probe;
      }
      int oldProbe = probe;
      probe = (highLim+lowLim)/2;
      if( probe == oldProbe)
        return -1;
    }

    return probe;
  }
}
