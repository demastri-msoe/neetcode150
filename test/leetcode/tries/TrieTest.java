package leetcode.tries;

import java.util.Collections;
import java.util.Dictionary;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrieTest {

  @Test
  public void trieTest() {
    Trie o = new Trie();
    o.insert( "apple" );
    Assertions.assertTrue( o.search("apple") );
    Assertions.assertFalse( o.search("app") );
    Assertions.assertTrue( o.startsWith("app") );
    o.insert( "app" );
    Assertions.assertTrue( o.search("app") );

    o = new Trie();
    o.insert( "a" );
    Assertions.assertTrue( o.search("a") );
    Assertions.assertTrue( o.startsWith("a") );
  }

  @Test
  public void dictionaryTest() {
    WordDictionary o = new WordDictionary();

    o.addWord( "bad" );
    o.addWord( "dad" );
    o.addWord( "mad" );
    Assertions.assertFalse( o.search( "pad" ));
    Assertions.assertTrue(o.search( "bad" ));
    Assertions.assertTrue(o.search( ".ad" ));
    Assertions.assertTrue(o.search( "b.." ));
  }

  @Test
  public void wordSearchTest() {
    WordSearch o = new WordSearch();

    List<String> outWords = o.findWords(
        new char[][] {{'a','b'},{'c','d'}},
        new String[] {"abcb"} );
    outWords.stream().sorted();
    Assertions.assertEquals( 0, outWords.size() );

    outWords = o.findWords(
        new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
        new String[] {"oath","pea","eat","rain"} );
    Collections.sort(outWords);
    Assertions.assertEquals( 2, outWords.size() );
    Assertions.assertEquals( "eat", outWords.get(0) );
    Assertions.assertEquals( "oath", outWords.get(1) );

    // solution fails time bounds online
    Assertions.assertTrue( false );
  }
}
