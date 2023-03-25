package leetcode.trees;

/**
 * Similar to Diameter, piggyback on depth balanced means there's never a gap of more than 1 between
 * any left or right depths in the tree
 */
public class Balanced {

  int maxDelta;

  public boolean isBalanced( TreeNode root ) {
    maxDelta = -1;
    getDepth( root );
    return maxDelta < 2;
  }

  public int getDepth( TreeNode root ) {
    if ( root == null ) {
      if ( maxDelta == -1 ) {
        maxDelta = 0;
      }
      return 0;
    }
    int l = getDepth( root.left );
    int r = getDepth( root.right );
    int thisDelta = ( l > r ) ? l - r : r - l;
    if ( thisDelta > maxDelta ) {
      maxDelta = thisDelta;
    }
    return ( l > r ? l : r ) + 1;
  }
}
