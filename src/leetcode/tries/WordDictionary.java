package leetcode.tries;

public class WordDictionary {

  Trie words;
  public WordDictionary( ) {
    words = new Trie();
  }

  public void addWord( String word ) {
    words.insert( word );
  }

  public boolean search( String word ) {
    return words.search( word );
  }

  private class Trie {

    boolean isWord;
    Trie[] children;

    public Trie( ) {
      isWord = false;
      children = new Trie[ 26 ];
    }

    public void insert( String word ) {
      Trie curTrie = this;
      for ( char c : word.toCharArray() ) {
        int thisIndex = c - 'a';
        if ( curTrie.children[ thisIndex ] == null ) {
          curTrie.children[ thisIndex ] = new Trie();
        }
        curTrie = curTrie.children[ thisIndex ];
      }
      curTrie.isWord = true;
    }

    public boolean search( String word ) {
      Trie curTrie = this;
      int index = 0;
      for ( char c : word.toCharArray() ) {
        if ( c == '.' ) {
          for ( Trie possTrie : curTrie.children ) {
            /* the rest of the word after ',' */
            if ( possTrie != null && possTrie.search( word.substring( index + 1 ) ) ) {
              return true;
            }
          }
          return false;
        } else {
          int thisIndex = c - 'a';
          if ( curTrie.children[ thisIndex ] == null ) {
            return false;
          }
          curTrie = curTrie.children[ thisIndex ];
        }
        index++;
      }
      return curTrie.isWord;
    }
  }
}