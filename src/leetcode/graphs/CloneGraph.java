/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/26/2023
 */
package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/clone-graph/
 * <p>
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * <p>
 */
public class CloneGraph {

    /**
     * Implementation of basic BFS of nodes, building the graph structure as we visit each one.
     *
     * To decide what node to process next, take from queue of unprocessed nodes.
     *  as we process nodes there must be a clone of this node as we encountered it as a neighbor.
     *  for each of this node's children
     *   get clone of this child (or create it if it doesn't exist)
     *   add it to the children of the clone of the node we're processing
     *   if we a) haven't already visited AND b) aren't queued to process this node
     *    add it to the unprocessed list
     * Mark a processed node as visited.
     *
     * @param node head of provided graph
     * @return cloned head of provided graph
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> cloned = new HashMap<>();
        Queue<Node> unprocessed = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();

        Integer firstVal = node.val;
        Node outNode = new Node(firstVal);
        cloned.put(firstVal, outNode);
        unprocessed.offer(node);

        do {
            node = unprocessed.poll();
            int thisVal = node.val;

            Node cloneNode = cloned.get(thisVal);
            for (Node n : node.neighbors) {
                cloned.putIfAbsent(n.val, new Node(n.val));
                Node cloneNeighbor = cloned.get(n.val);
                cloneNode.neighbors.add(cloneNeighbor);

                // so if i haven't visited it and it's not on my list to visit
                if (!unprocessed.contains(n) && !visited.contains(n.val)) {
                    unprocessed.offer(n);
                }
            }
            visited.add(node.val);
            // get next one
        } while (!unprocessed.isEmpty());

        return outNode;
    }
}
