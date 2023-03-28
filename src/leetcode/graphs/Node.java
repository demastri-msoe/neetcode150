/**
 * Course: NA but helpful for data structures...
 * Author: provided by leetcode, modified for style by John DeMastri
 * Date: 3/26/2023
 */
package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
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