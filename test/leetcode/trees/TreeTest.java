package leetcode.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TreeTest {

  @Test
  public void invertTest( ) {
    InvertTree o = new InvertTree();

    TreeNode root = new TreeNode( 4,
        new TreeNode( 2,
            new TreeNode( 1 ),
            new TreeNode( 3 ) ),
        new TreeNode( 7,
            new TreeNode( 6 ),
            new TreeNode( 9 ) ) );

    TreeNode outTree = o.invertTree( root );
    Assertions.assertEquals( 4, outTree.val );
    Assertions.assertEquals( 7, outTree.left.val );
    Assertions.assertEquals( 9, outTree.left.left.val );
    Assertions.assertEquals( 6, outTree.left.right.val );
    Assertions.assertNull( outTree.left.left.left );
    Assertions.assertNull( outTree.left.left.right );
    Assertions.assertNull( outTree.left.right.left );
    Assertions.assertNull( outTree.left.right.right );
    Assertions.assertEquals( 2, outTree.right.val );
    Assertions.assertEquals( 3, outTree.right.left.val );
    Assertions.assertEquals( 1, outTree.right.right.val );
    Assertions.assertNull( outTree.right.left.left );
    Assertions.assertNull( outTree.right.left.right );
    Assertions.assertNull( outTree.right.right.left );
    Assertions.assertNull( outTree.right.right.right );

    outTree = o.invertTree( new TreeNode( 2,
        new TreeNode( 1 ),
        new TreeNode( 3 ) ) );
    Assertions.assertEquals( 2, outTree.val );
    Assertions.assertEquals( 3, outTree.left.val );
    Assertions.assertEquals( 1, outTree.right.val );
    Assertions.assertNull( outTree.left.left );
    Assertions.assertNull( outTree.left.right );
    Assertions.assertNull( outTree.right.left );
    Assertions.assertNull( outTree.right.right );

    Assertions.assertNull( o.invertTree( null ) );
  }

  @Test
  public void depthTest( ) {
    Diameter o = new Diameter();

    Assertions.assertEquals( 3, o.diameterOfBinaryTree(
        new TreeNode( 3,
            new TreeNode( 2,
                new TreeNode( 4 ),
                new TreeNode( 5 ) ),
            new TreeNode( 3 ) ) ) );

    Assertions.assertEquals( 1, o.diameterOfBinaryTree(
        new TreeNode( 1,
            new TreeNode( 2 ),
            null ) ) );

    //[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
    Assertions.assertEquals( 8, o.diameterOfBinaryTree(
        new TreeNode( 4,
            new TreeNode( -7 ),
            new TreeNode( -3,
                new TreeNode( -9,
                    new TreeNode( 9,
                        new TreeNode( 6,
                            new TreeNode( 0,
                                null,
                                new TreeNode( -1 ) ),
                            new TreeNode( 6,
                                new TreeNode( -4 ),
                                null ) ),
                        null ),
                    new TreeNode( -4,
                        new TreeNode( -6,
                            new TreeNode( 5 ),
                            null ),
                        new TreeNode( -6,
                            new TreeNode( 9,
                                new TreeNode( -2 ),
                                null ),
                            null ) ) ),
                new TreeNode( -3,
                    new TreeNode( -4 ),
                    null ) ) ) ) );
  }

  @Test
  public void sameTreeTest( ) {
    SameTree o = new SameTree();

    Assertions.assertTrue( o.isSameTree(
        new TreeNode( 1,
            new TreeNode( 2 ),
            new TreeNode( 3 ) ),
        new TreeNode( 1,
            new TreeNode( 2 ),
            new TreeNode( 3 ) )
    ) );

    Assertions.assertFalse( o.isSameTree(
        new TreeNode( 1,
            new TreeNode( 2 ),
            null ),
        new TreeNode( 1,
            null,
            new TreeNode( 2 ) )
    ) );

    Assertions.assertFalse( o.isSameTree(
        new TreeNode( 1,
            new TreeNode( 2 ),
            new TreeNode( 1 ) ),
        new TreeNode( 1,
            new TreeNode( 1 ),
            new TreeNode( 2 ) )
    ) );
  }

  @Test
  public void balanceTest( ) {
    Balanced o = new Balanced();

    Assertions.assertTrue( o.isBalanced(
        new TreeNode( 3,
            new TreeNode( 9 ),
            new TreeNode( 20,
                new TreeNode( 15 ),
                new TreeNode( 7 ) ) )
    ) );

    Assertions.assertFalse( o.isBalanced(
        new TreeNode( 1,
            new TreeNode( 2,
                new TreeNode( 3,
                    new TreeNode( 4 ),
                    new TreeNode( 4 ) ),
                new TreeNode( 3 ) ),
            new TreeNode( 2 ) )
    ) );

    Assertions.assertTrue( o.isBalanced( null ) );
  }

  @Test
  public void hasSubtreeTest( ) {
    Subtree o = new Subtree();

    Assertions.assertTrue( o.isSubtree(
        new TreeNode(3,
            new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2)),
            new TreeNode(5)),
        new TreeNode(4,
            new TreeNode(1),
            new TreeNode(2))
    ) );

    Assertions.assertFalse( o.isSubtree(
        new TreeNode(3,
            new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2,
                    new TreeNode(0),
                    null)),
            new TreeNode(5)),
        new TreeNode(4,
            new TreeNode(1),
            new TreeNode(2))
    ) );

    Assertions.assertFalse( o.isSubtree(
        new TreeNode(3,
            new TreeNode(4,
                new TreeNode(1),
                null),
            new TreeNode(5,
                new TreeNode(2),
                null)),
        new TreeNode(3,
            new TreeNode(1),
            new TreeNode(2))
    ));

  }
}
