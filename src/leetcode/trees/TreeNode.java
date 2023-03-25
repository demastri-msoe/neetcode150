package leetcode.trees;

/**
 * Definition for tree data node. Given...
 */
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode( ) {
  }

  TreeNode( int val ) {
    this.val = val;
  }

  TreeNode( int val, TreeNode left, TreeNode right ) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}