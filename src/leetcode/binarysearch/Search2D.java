package leetcode.binarysearch;

public class Search2D {
  public boolean searchMatrix(int[][] matrix, int target) {
    int cols = matrix[0].length;
    int rows = matrix.length;
    int length = rows*cols;
    int lowLim = 0;
    int highLim = length;
    int probe = length/2;

    while(matrix[probe/cols][probe%cols] != target) {
      if( matrix[probe/cols][probe%cols] > target) {
        highLim = probe;
      } else {
        lowLim = probe;
      }
      int oldProbe = probe;
      probe = (highLim+lowLim)/2;
      if( probe == oldProbe)
        return false;
    }

    return true;

  }
}
