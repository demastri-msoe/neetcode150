/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/30/2023
 */
package leetcode.advancedgraphs;

import java.util.*;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * <p>
 * You are given an array points representing integer coordinates of some points on a
 * 2D-plane, where points[i] = [xi, yi].
 * <p>
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance
 * between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * <p>
 * Return the minimum cost to make all points connected. All points are connected if
 * there is exactly one simple path between any two points.
 */
public class MinCostToConnect {
    Map<Integer, GraphNode> nodeList;
    List<Edge> edgeList;

    /**
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        GraphNode firstNode = new GraphNode(0, points[0]);
        nodeList = new HashMap<>();
        nodeList.put(0, firstNode);
        edgeList = new ArrayList<>();

        for (int i = 0; i < points.length - 1; i++) {
            GraphNode curNode = nodeList.get(i);
            for (int j = i + 1; j < points.length; j++) {
                GraphNode nextNode;
                if (i == 0) { // seed the spanning tree
                    nextNode = new GraphNode(j, points[j]);
                    nodeList.put(j, nextNode);
                    Edge newEdge = new Edge(curNode, nextNode);
                    curNode.addNeighbor(newEdge);
                    nextNode.addNeighbor(newEdge);
                    edgeList.add(newEdge);
                    // after this loop completes, edges from 0->each exist in edgeList
                    // a path from any two nodes (where neither is node 0) exists through node 0
                } else {
                    // for each pass, see if this edge would reduce 1+ paths
                    // if the longest edge on the current path from i->j is > than the direct path from i->j, replace it
                    Edge possEdge = new Edge(nodeList.get(i), nodeList.get(j));
                    //printEdges(possEdge);
                    Edge longestEdge = findLongestEdgeOnPath(i, j);
                    if (longestEdge.distance > possEdge.distance) {
                        edgeList.remove(longestEdge);
                        longestEdge.a.neighbors.remove(longestEdge);
                        longestEdge.b.neighbors.remove(longestEdge);
                        edgeList.add(possEdge);
                        possEdge.a.neighbors.add(possEdge);
                        possEdge.b.neighbors.add(possEdge);
                    }
                }
            }
        }
        printEdges(null);
        int treeSpan = 0;
        for (Edge e : edgeList) {
            treeSpan += e.distance;
        }
        return treeSpan;
    }

    void printEdges(Edge p) {
        if( p == null) {
            System.out.print(" Final: ");
        } else {
            System.out.print("[ <" + p.a.id + "," + p.b.id + ">: " + p.distance + "] ");
        }
        for (Edge e : edgeList) {
            System.out.print("(<" + e.a.id + "," + e.b.id + ">: " + e.distance+") ");
        }
        System.out.println();
        for(GraphNode g: nodeList.values()) {
            for( Edge e: g.neighbors) {
                if( !edgeList.contains(e)) {
                    System.out.println("  !! Edge on node "+g.id+" [ <" + e.a.id + "," + e.b.id + ">: " + e.distance+"] is not on the edgeList!!");
                }
            }
        }

    }


    Edge findLongestEdgeOnPath(int s, int e) {
        // edgeList is a spanning tree across all nodes.
        // for every edge, if a path doesn't exist if it's excluded, it's critical, check if it's the longest seen
        Iterator<Edge> edgeIter = edgeList.iterator();
        Edge curLongestEdge = null;
        while (edgeIter.hasNext()) {
            Edge edge = edgeIter.next();
            if (!pathExists(s, e, edge)) {
                if (curLongestEdge == null || edge.distance >= curLongestEdge.distance) {
                    curLongestEdge = edge;
                }
            }
        }
        return curLongestEdge;
    }

    List<Integer> visited;
    Queue<Integer> waiting;

    boolean pathExists(int startNodeID, int endNodeID, Edge edgeToExclude) {
        // it's a spanning tree - no cycles, this can be simpler
        // follow each edges to its neighbors, excluding the path that would be excluded
        // if you can still get to the target, the path exists...
        visited = new ArrayList<>();
        waiting = new LinkedList<>();

        waiting.add(startNodeID);

        while (!waiting.isEmpty()) {
            GraphNode curNode = nodeList.get(waiting.poll());
            visited.add(curNode.id);
            for (Edge e : curNode.neighbors) {
                if (e == edgeToExclude) {
                    continue;
                }
                int otherEnd = (e.a.id == curNode.id ? e.b.id : e.a.id);
                if (otherEnd == endNodeID) {
                    return true;
                }
                if (!visited.contains(otherEnd) && !waiting.contains(otherEnd)) {
                    waiting.add(otherEnd);
                }
            }
        }
        return false;
    }

    static int dManhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    class Edge {
        int id;
        GraphNode a;
        GraphNode b;
        int distance;

        Edge(GraphNode a, GraphNode b) {
            this.a = a;
            this.b = b;
            distance = a.distanceTo(b);
        }

    }

    class GraphNode {
        int id;
        int x, y;
        List<Edge> neighbors;

        GraphNode(int id, int[] loc) {
            this.id = id;
            x = loc[0];
            y = loc[1];
            neighbors = new ArrayList<>();
        }

        void addNeighbor(Edge e) {
            neighbors.add(e);
        }

        int distanceTo(GraphNode n) {
            return Math.abs(x - n.x) + Math.abs(y - n.y);
        }
    }
}