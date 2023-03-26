package leetcode.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch {

  int rows;
  int cols;

  private class Board {

    char c;
    boolean isUsed;
    Board[] neighbors;

    Board( char c ) {
      this.c = c;
      neighbors = new Board[ 4 ];
    }
  }

  Board[][] bd;
  List<Board>[] charKey;

  public List<String> findWords( char[][] board, String[] words ) {
    initBoard( board );

    List<String> outList = new ArrayList<>();
    for ( String s : words ) {
      clearUsage();
      if ( find( s ) ) {
        outList.add( s );
      }
    }
    return outList;
  }

  private boolean find( String s ) {
    if( charKey[s.charAt( 0 )-'a'] == null ) {
      return false;
    }
    for ( Board b : charKey[ s.charAt( 0 )-'a' ] ) {
      if ( !b.isUsed ) {
        b.isUsed = true;
        if ( s.length() == 1 || findFromNeighbors( b, s.substring( 1 ) ) ) {
          return true;
        }
        b.isUsed = false;
      }
    }
    return false;
  }

  private boolean findFromNeighbors( Board b, String s ) {
    for ( Board n : b.neighbors ) {
      if ( n != null && !n.isUsed && n.c == s.charAt( 0 ) ) {
        n.isUsed = true;
        if ( s.length() == 1 || findFromNeighbors( n, s.substring( 1 ) ) )
          return true;
        n.isUsed = false;
      }
    }
    return false;
  }

  private void clearUsage( ) {
    for ( int r = 0; r < rows; r++ ) {
      for ( int c = 0; c < cols; c++ ) {
        bd[ r ][ c ].isUsed = false;
      }
    }
  }

  private void initBoard( char[][] board ) {
    rows = board.length;
    cols = board[ 0 ].length;
    bd = new Board[ rows ][ cols ];
    charKey = new ArrayList[ 26 ];
    for ( int r = 0; r < rows; r++ ) {
      for ( int c = 0; c < cols; c++ ) {
        Board thisLoc = new Board( board[ r ][ c ] );
        bd[ r ][ c ] = thisLoc;
        if ( charKey[ board[ r ][ c ] - 'a' ] == null ) {
          charKey[ board[ r ][ c ] - 'a' ] = new ArrayList<>();
        }
        charKey[ board[ r ][ c ] - 'a' ].add( thisLoc );
      }
    }
    for ( int r = 0; r < rows; r++ ) {
      for ( int c = 0; c < cols; c++ ) {
        Board thisLoc = bd[ r ][ c ];
        if ( r > 0 ) {
          thisLoc.neighbors[ 0 ] = bd[ r - 1 ][ c ];
        }
        if ( r < rows - 1 ) {
          thisLoc.neighbors[ 1 ] = bd[ r + 1 ][ c ];
        }
        if ( c > 0 ) {
          thisLoc.neighbors[ 2 ] = bd[ r ][ c - 1 ];
        }
        if ( c < cols - 1 ) {
          thisLoc.neighbors[ 3 ] = bd[ r ][ c + 1 ];
        }
      }
    }
  }

}
