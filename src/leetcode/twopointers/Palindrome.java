package leetcode.twopointers;

public class Palindrome {

  public boolean isPalindrome( String s ) {
    s = s.toLowerCase();
    int l = GetNextChar( s, -1, 1 );
    int r = GetNextChar( s, s.length(), -1 );

    while( l < r && r>=0 && l>=0) {
      if( s.charAt( l ) != s.charAt( r ) )
        return false;
      l = GetNextChar( s, l, 1 );
      r = GetNextChar( s, r, -1 );
    }
    return true;
  }

  private int GetNextChar( String s, int loc, int inc ) {
    loc += inc;
    if( loc < 0 || loc >= s.length() )
      return -1;
    if( Character.isLetterOrDigit(s.charAt( loc )) )
      return loc;
    return GetNextChar( s, loc, inc );
  }
}
