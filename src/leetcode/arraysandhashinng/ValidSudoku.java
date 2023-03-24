package leetcode.arraysandhashinng;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    int [] rowBase = new int[] { 0,1,2,3,4,5,6,7,8};
    int [] colBase = new int[] { 0,9,18,27,36,45,54,63,72};
    int [] boxBase = new int[] { 0,1,2,9,10,11,18,19,20};

    // doRows
    for( int i=0; i<9; i++ ) {
      if(!checkSubset(board, rowBase)) {
        return false;
      }
      for( int j=0; j<9; j++ ) {
        rowBase[j] += 9;
      }
    }
    // doCols
    for( int i=0; i<9; i++ ) {
      if(!checkSubset(board, colBase)) {
        return false;
      }
      for( int j=0; j<9; j++ ) {
        colBase[j] += 1;
      }
    }
    // doboxes
    for( int i=0; i<9; i++ ) {
      if(!checkSubset(board, boxBase)) {
        return false;
      }
      for( int j=0; j<9; j++ ) {
        boxBase[j] += 3;
      }
      if( (i%3) == 2)
        for( int j=0; j<9; j++ ) {
            boxBase[j] += 18;
        }
    }

    return true;
  }

  private boolean checkSubset( char[][] b, int [] index) {
    List<Integer> outList = new ArrayList();
    for(int i: index) {
      int r = i/9;
      int c = i%9;
      char cell = b[r][c];
      if( cell == '.')
        continue;
      if( Character.isDigit( cell ) && cell != '0') {
        if( outList.contains( new Integer( cell) ) ) {
          return false;
        } else {
          outList.add( new Integer( cell ));
        }
      } else {
        return false;
      }
    }
    return true;
  }

}
