package leetcode.graphs;

public class SurroundedRegions {
    /**
     * https://leetcode.com/problems/surrounded-regions/
     *
     * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * set all values contigous to the edge to some placeholder values
     * set all remaining non-zero values to zero
     * replace placeholder values to 1
     *
     * @param board the 0/1 values for water/land respectively
     * @return the updated board
     */
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < 2; y++) {
                int yCheck = y == 0 ? 0 : cols-1;
                if (board[x][yCheck] == 'O') {
                    doDFS(board, rows, cols, x, yCheck, 'O', '-');
                }
            }
        }
        for (int x = 0; x < 2; x++) {
            for (int y = 1; y < cols-1; y++) {
                int xCheck = x == 0 ? 0 : rows-1;
                if (board[xCheck][y] == 'O') {
                    doDFS(board, rows, cols, xCheck, y, 'O', '-');
                }
            }
        }
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if( board[x][y] == 'O')
                    board[x][y] = 'X';
                if( board[x][y] == '-')
                    board[x][y] = 'O';
            }
        }
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
    public void doDFS(char[][] grid, int rows, int cols, int r, int c, char targetFind, char target) {
        if( r < 0 || c<0)
            System.out.println();

        grid[r][c] = target;
        if (r > 0 && grid[r - 1][c] == targetFind) {
            doDFS(grid, rows, cols, r - 1, c, targetFind, target);
        }
        if (r < rows - 1 && grid[r + 1][c] == targetFind) {
            doDFS(grid, rows, cols, r + 1, c, targetFind, target);
        }
        if (c < cols - 1 && grid[r][c + 1] == targetFind) {
            doDFS(grid, rows, cols, r, c + 1, targetFind, target);
        }
        if (c > 0 && grid[r][c - 1] == targetFind) {
            doDFS(grid, rows, cols, r, c - 1, targetFind, target);
        }
    }
}
