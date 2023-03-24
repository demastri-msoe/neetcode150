package leetcode.mathandgeometry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> seq = new HashSet<>();

    seq.add( n );
    while(true){
      n = getIter(n);
      if( n == 1 )
        return true;
      if( !seq.add( n ))
        return false;
    }
  }
  private int getIter( int v ) {
    int sum = 0;
    while(v > 0) {
      sum += (v%10) * (v%10);
      v /= 10;
    }
    return sum;
  }
}
