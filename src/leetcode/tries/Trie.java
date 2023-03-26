package leetcode.tries;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Trie {

  boolean isWord;
  Trie[] children;

  public Trie( ) {
    isWord = false;
    children = new Trie[ 26 ];
  }

  public void insert( String word ) {
    Trie curTrie = this;
    for( char c: word.toCharArray()) {
      int thisIndex = c-'a';
      if ( curTrie.children[thisIndex] == null ) {
        curTrie.children[thisIndex] = new Trie( );
      }
      curTrie = curTrie.children[thisIndex];
    }
    curTrie.isWord = true;
  }

  public boolean search( String word ) {
    Trie curTrie = this;
    for( char c: word.toCharArray()) {
      int thisIndex = c-'a';
      if ( curTrie.children[thisIndex] == null ) {
        return false;
      }
      curTrie = curTrie.children[thisIndex];
    }
    return curTrie.isWord;
  }

  public boolean startsWith( String prefix ) {
    Trie curTrie = this;
    for( char c: prefix.toCharArray()) {
      int thisIndex = c-'a';
      if ( curTrie.children[thisIndex] == null ) {
        return false;
      }
      curTrie = curTrie.children[thisIndex];
    }
    return true;
  }
}
