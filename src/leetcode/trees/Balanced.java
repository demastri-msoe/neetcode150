/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/23/2023
 */
package leetcode.trees;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Given a binary tree, determine if it is
 * height-balanced
 */
public class Balanced {
    private int maxDelta;

    /**
     *  Similar to Diameter, piggyback on depth balanced means there's
     *  never a gap of more than 1 between
     *  any left or right depths in the tree
     *
     * @param root
     * @return true if the bbiggest gap is < 2
     */
    public boolean isBalanced(TreeNode root) {
        maxDelta = -1;
        getDepth(root);
        return maxDelta < 2;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            if (maxDelta == -1) {
                maxDelta = 0;
            }
            return 0;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        int thisDelta = (l > r) ? l - r : r - l;
        if (thisDelta > maxDelta) {
            maxDelta = thisDelta;
        }
        return (l > r ? l : r) + 1;
    }
}
