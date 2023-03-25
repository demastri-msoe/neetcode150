package leetcode.trees;

public class Subtree {

  public boolean isSubtree( TreeNode root, TreeNode subRoot ) {
    return matchSubTree( root, subRoot ) || (root != null && (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)));
  }
  boolean matchSubTree( TreeNode root, TreeNode subRoot ) {
    return ( root == subRoot ) ||
        (root != null && subRoot != null && root.val == subRoot.val &&
            matchSubTree( root.left, subRoot.left ) && matchSubTree( root.right, subRoot.right ));
  }
}
