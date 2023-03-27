package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// passes but not as efficient as I'd like...
public class CloneGraph {
  public Node cloneGraph(Node node) {
    if( node == null)
      return null;
    Map<Integer, Node> cloned = new HashMap<>();
    Queue<Node> unvisited = new LinkedList<>();
    List<Integer> visited = new ArrayList<>();

    Integer firstVal = node.val;
    unvisited.offer( node );

    do {
      node = unvisited.poll();
      int thisVal = node.val;

      if( !visited.contains( thisVal ) ) {
        Node cloneNode = null;
        if( cloned.containsKey( thisVal )) {
          cloneNode = cloned.get(thisVal);
        }else {
          cloneNode = new Node( thisVal );
          cloned.put(thisVal, cloneNode);
        }
        for( Node n: node.neighbors ) {
          Node cloneNeighbor = null;
          if( cloned.containsKey( n.val )) {
            cloneNeighbor = cloned.get(n.val);
          } else {
            cloneNeighbor = new Node(n.val);
            cloned.put( n.val, cloneNeighbor );
          }
          cloneNode.neighbors.add( cloneNeighbor );

          // so if i haven't visited it and it's not on my list to visit
          if( !unvisited.contains( n ) && !visited.contains( n.val )) {
            unvisited.offer( n );
          }
        }
      }
      visited.add( node.val );
      // get next one
    } while (!unvisited.isEmpty());

    return cloned.get( firstVal );
  }
}
