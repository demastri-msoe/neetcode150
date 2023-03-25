package leetcode.trees;

/**
 * This is a nice O(n) solution that piggybacks off of depth.
 * Note that the max path between two nodes is the l+r depths at their first common node.
 * ABOVE that node, l+r depths could mask that path, so you have to keep the biggest seen path.
 * Since depth requires passing back the actual depth, need an additional instance var to keep
 * that diameter - not really pretty, but fast.
 */
public class Diameter {

  int maxDiameter;
  public int diameterOfBinaryTree( TreeNode root ) {
    maxDiameter = -1;
    int maxDepth = getDepth( root );
    return maxDiameter;
  }

  public int getDepth( TreeNode root ) {
    if ( root == null ) {
      return 0;
    }
    int l = getDepth( root.left );
    int r = getDepth( root.right );
    int thisDiameter = l+r;
    if( thisDiameter > maxDiameter)
      maxDiameter = thisDiameter;
    return ( l > r ? l : r ) + 1;
  }
}
