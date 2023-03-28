/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/28/2023
 */
package leetcode.graphs;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the
 * grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * <p>
 * JPD - with the solution to nbr of islands in hand, this was pretty trivial...
 */
public class MaxAreaOfIsland {

    /**
     * for each island found, dfs to see its extent, and return its size
     * maintain the max size seen
     *
     * @param grid the 0/1 values for water/land respectively
     * @return the max island size seen
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (grid[x][y] == 1) {
                    int islandSize = doDFS(grid, rows, cols, x, y, 0);
                    if (maxSize < islandSize) {
                        maxSize = islandSize;
                    }
                }
            }
        }
        return maxSize;
    }

    /**
     * for each item seen, search neighbors for contiguity
     * set this to 0, and look for each of the 4 possible neighbors
     * maintain a running count of the size seen so far and return it
     *
     * @param grid
     * @param rows
     * @param cols
     * @param r
     * @param c
     * @param size
     * @return the current size of the island seen (including all scanned neighbors)
     */
    public int doDFS(int[][] grid, int rows, int cols, int r, int c, int size) {
        size += 1;
        grid[r][c] = 0;
        if (r > 0 && grid[r - 1][c] == 1) {
            size += doDFS(grid, rows, cols, r - 1, c, 0);
        }
        if (r < rows - 1 && grid[r + 1][c] == 1) {
            size += doDFS(grid, rows, cols, r + 1, c, 0);
        }
        if (c < cols - 1 && grid[r][c + 1] == 1) {
            size += doDFS(grid, rows, cols, r, c + 1, 0);
        }
        if (c > 0 && grid[r][c - 1] == 1) {
            size += doDFS(grid, rows, cols, r, c - 1, 0);
        }
        return size;
    }

}
