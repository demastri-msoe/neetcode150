package leetcode.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GraphTest {

  @Test
  public void cloneTest() {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n1.neighbors.add( n2 );
    n1.neighbors.add( n4 );
    n2.neighbors.add( n1 );
    n2.neighbors.add( n3 );
    n3.neighbors.add( n2 );
    n3.neighbors.add( n4 );
    n4.neighbors.add( n1 );
    n4.neighbors.add( n3 );

    CloneGraph o = new CloneGraph();
    Node o1 = o.cloneGraph( n1 );
    Assertions.assertNotEquals( o1, n1 );
    Assertions.assertEquals( o1.val, n1.val );

    Assertions.assertEquals( 2, o1.neighbors.size() );
    Node o2 = o1.neighbors.get(0);
    Node o4 = o1.neighbors.get(1);
    if( o2.val == 4 ) {
      Node t = o2;
      o2 = o4;
      o4 = t;
    }
    Assertions.assertTrue( o2.val == 2 && o4.val == 4 );

    Assertions.assertEquals( 2, o2.neighbors.size() );
    Node o3 = o2.neighbors.get(0);
    Node o1a = o2.neighbors.get(1);
    if( o3.val == 1 ) {
      Node t = o3;
      o3 = o1a;
      o1a = t;
    }
    Assertions.assertTrue( o3.val == 3 && o1a == o1 );

    Assertions.assertEquals( 2, o3.neighbors.size() );
    Node o2a = o3.neighbors.get(0);
    Node o4a = o3.neighbors.get(1);
    if( o2a.val == 4 ) {
      Node t = o2a;
      o2a = o4a;
      o4a = t;
    }
    Assertions.assertTrue( o2a == o2 && o4a == o4 );

    Assertions.assertEquals( 2, o4.neighbors.size() );
    Node o1b = o4.neighbors.get(0);
    Node o3a = o4.neighbors.get(1);
    if( o1b.val == 3 ) {
      Node t = o1b;
      o1b = o3a;
      o3a = t;
    }
    Assertions.assertTrue( o1b == o1 && o3a == o3 );

    n1 = new Node(1);
    o1 = o.cloneGraph( n1 );
    Assertions.assertNotEquals( o1, n1 );
    Assertions.assertEquals( o1.val, n1.val );
    Assertions.assertEquals( 0, o1.neighbors.size() );

    Assertions.assertNull( o.cloneGraph( null ));
  }
}
