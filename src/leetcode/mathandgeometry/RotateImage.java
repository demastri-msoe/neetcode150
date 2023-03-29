/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/26/2023
 */

package leetcode.mathandgeometry;

/**
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {

    /**
     * Treat the image as a series of rings, each to be rotated in turn
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int nbrRings = matrix[0].length / 2;
        int ringSize = matrix[0].length;

        for (int i = 0; i < nbrRings; i++) {
            for (int r = 0; r < ringSize - 1; r++) {
                rotateRing(matrix, i, ringSize);
            }
            ringSize -= 2;
        }
    }

    private void rotateRing(int[][] m, int offset, int width) {
        // update the top row
        int curCell = m[offset + 1][offset];
        for (int c = 0; c < width; c++) {
            int nextVal = m[offset][offset + c];
            m[offset][offset + c] = curCell;
            curCell = nextVal;
        }
        // update the right column
        for (int c = 1; c < width; c++) {
            int nextVal = m[offset + c][offset + width - 1];
            m[offset + c][offset + width - 1] = curCell;
            curCell = nextVal;
        }
        // update the bottom row
        for (int c = width - 2; c >= 0; c--) {
            int nextVal = m[offset + width - 1][offset + c];
            m[offset + width - 1][offset + c] = curCell;
            curCell = nextVal;
        }
        // update the left col
        for (int c = width - 2; c >= 1; c--) {
            int nextVal = m[offset + c][offset];
            m[offset + c][offset] = curCell;
            curCell = nextVal;
        }
    }
}
