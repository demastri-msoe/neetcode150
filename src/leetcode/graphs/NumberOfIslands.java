/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/26/2023
 */
package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-islands/
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 */
public class NumberOfIslands {

    static final int INDEX_PAD = 5;

    /**
     * is it as simple as increment for every land, decrement for each other it's adjacent to?? No
     * but it is as simple as determining if I'm next to two islands whether the total count
     * goes down or not.  It comes down to whether the two nodes (up and left) had a path to each
     * other beforehand, which is what makes it a graph problem, lol.
     * <p>
     * this is 8x faster than the brute force, but still needs to be 20x faster still...
     * the elegant solution is so cool - dfs when you see any land and set any land you see to 0,
     * count the 1's the original code sees...
     *
     * <p>
     * Create a DLL, add node for each 1 found - increment total
     * connect as neighbor to each neighbor found to left - decrement total
     * connect as neighbor to each neighbor found above
     * if both are found - if there was a path from upper to left prior to this node, inc again
     *
     * @param grid input mxn grid, 1 = land, 0 = water
     * @return the number of discrete islands found
     */
    public int numIslands(char[][] grid) {
        int totalIslandsFound = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (grid[x][y] == '1') {
                    doDFS(grid, rows, cols, x, y);
                    totalIslandsFound++;
                }
            }
        }
        return totalIslandsFound;
    }

    /**
     * for each item seen, search neighbors for contiguity
     * set this to 0, and look for each of the 4 possible neighbors
     *
     * @param grid
     * @param rows
     * @param cols
     * @param r
     * @param c
     */
    public void doDFS(char[][] grid, int rows, int cols, int r, int c) {
        grid[r][c] = '0';
        if (r > 0 && grid[r - 1][c] == '1') {
            doDFS(grid, rows, cols, r - 1, c);
        }
        if (r < rows - 1 && grid[r + 1][c] == '1') {
            doDFS(grid, rows, cols, r + 1, c);
        }
        if (c < cols - 1 && grid[r][c + 1] == '1') {
            doDFS(grid, rows, cols, r, c + 1);
        }
        if (c > 0 && grid[r][c - 1] == '1') {
            doDFS(grid, rows, cols, r, c - 1);
        }

    }


    /**
     * maintains a separate list for all seen islands
     * and a map of each node's current island
     *
     * sssssllllooooooowwwwwwww
     *
     * @param grid
     * @return islands found
     */
    public int numIslandsSepList(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<Set<Node>> islands = new ArrayList<>();
        Map<Node, Set<Node>> nodeIsland = new HashMap<>();

        Node[][] graphNodes = new Node[rows][cols];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (grid[x][y] == '1') {
                    Node curNode = graphNodes[x][y] = new Node(x * (cols + INDEX_PAD) + y);
                    Node upNode = null;
                    Node leftNode = null;
                    Set<Node> upIsland = null;
                    Set<Node> leftIsland = null;

                    if (y > 0 && grid[x][y - 1] == '1') {
                        leftNode = graphNodes[x][y - 1];
                        leftIsland = nodeIsland.get(leftNode);
                    }
                    // neighboring island above...
                    if (x > 0 && grid[x - 1][y] == '1') {
                        upNode = graphNodes[x - 1][y];
                        upIsland = nodeIsland.get(upNode);
                    }
                    if (upNode != null && leftNode != null) {
                        // if path already exists between a/b, increment islandsFound
                        if (leftIsland != upIsland) {
                            // need to merge the islands.
                            islands.remove(leftIsland);
                            for (Node n : leftIsland) {
                                nodeIsland.put(n, upIsland);
                            }
                            upIsland.addAll(leftIsland);
                            nodeIsland.put(leftNode, upIsland);
                        }
                    }
                    // now patch this node into the expanding graph
                    // at this point, at max only one island is "live"
                    if (upIsland != null) {
                        upIsland.add(curNode);
                        nodeIsland.put(curNode, upIsland);
                    } else if (leftIsland != null) {
                        leftIsland.add(curNode);
                        nodeIsland.put(curNode, leftIsland);
                    } else {
                        // need to create a new one!
                        Set<Node> thisIsland = new HashSet<>();
                        islands.add(thisIsland);
                        thisIsland.add(curNode);
                        nodeIsland.put(curNode, thisIsland);
                        System.out.println("Interim>>");
                        printIslands(rows, cols, islands);
                    }
                }
            }
        }
        System.out.println("Final>>");
        printIslands(rows, cols, islands);
        return islands.size();
    }

    /**
     * helper method to visualize the grid during processing
     * @param rows
     * @param cols
     * @param islands
     */
    public void printIslands(int rows, int cols, List<Set<Node>> islands) {
        int[][] g = new int[rows][cols];
        for (int i = 1; i <= islands.size(); i++) {
            Set<Node> isl = islands.get(i - 1);
            for (Node n : isl) {
                int thisRow = n.val / (cols + INDEX_PAD);
                int thisCol = n.val % (cols + INDEX_PAD);
                g[thisRow][thisCol] = i;
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(g[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }

        Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

    }

    /**
     * As you encounter land from l-r, t-b, if it's adjacent to 1 island, label it with that tag.
     * If it's adjacent to more than one island, they are all contiguous and should be remapped.
     * doesn't have to be redone actually, can be logical.
     *
     * @param grid input mxn grid, 1 = land, 0 = water
     * @return the number of discrete islands found
     */
    public int numIslandsBruteForce(char[][] grid) {
        int totalIslandsFound = 0;
        int totalIslandsEverFound = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (grid[x][y] == '1') {
                    grid[x][y] = '0'; // unlabeled for the moment...
                    // neighboring island to the left...
                    if (y > 0 && grid[x][y - 1] != '0') {
                        grid[x][y] = grid[x][y - 1]; // add me to that island, yessir
                    }
                    // neighboring island above...
                    if (x > 0 && grid[x - 1][y] != '0') {
                        // if i'm still unlabeled or this is the same island as to the left
                        if (grid[x][y] == '0' || grid[x][y] == grid[x - 1][y]) {
                            grid[x][y] = grid[x - 1][y]; // add me to that island, yessir
                        } else {
                            // it's another island - we have to join them...
                            for (int x1 = 0; x1 <= x; x1++) {
                                for (int y1 = 0; y1 < cols; y1++) {
                                    // don't process the rest of the current row...
                                    if (x1 == x && y1 > y) {
                                        continue;
                                    }
                                    // take the one from the prior row...either is ok
                                    if (grid[x1][y1] == grid[x][y]) {
                                        grid[x1][y1] = grid[x - 1][y];
                                    }
                                }
                            }
                            totalIslandsFound--;
                        }
                    }
                    // man without a country...
                    if (grid[x][y] == '0') {
                        totalIslandsFound++;
                        grid[x][y] = (char) (++totalIslandsEverFound + '0');
                    }
                }
            }
        }
        return totalIslandsFound;
    }
}
