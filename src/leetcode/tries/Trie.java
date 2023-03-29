/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/26/2023
 */

package leetcode.tries;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store
 * and retrieve keys in a dataset of strings. There are various applications of this data structure,
 * such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted
 * before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that
 * has the prefix prefix, and false otherwise.
 *
 */
public class Trie {

    static final int ALPHABET_SIZE = 26;
    private boolean isWord;
    private Trie[] children;

    /**
     * constructor for the data structure
     * each node represents a letter based on where in it's parent structure it appears
     * it's children are populated as the appropriate letters are seen.
     */
    public Trie() {
        isWord = false;
        children = new Trie[ALPHABET_SIZE];
    }

    /**
     * add the word to the Trie, a character at a time
     *
     * @param word
     */
    public void insert(String word) {
        Trie curTrie = this;
        for (char c : word.toCharArray()) {
            int thisIndex = c - 'a';
            if (curTrie.children[thisIndex] == null) {
                curTrie.children[thisIndex] = new Trie();
            }
            curTrie = curTrie.children[thisIndex];
        }
        curTrie.isWord = true;
    }

    /**
     * search the Trie to find the given word
     * relies on the marker at the end to see if the word
     * (or just a prefix) was added
     *
     * @param word
     * @return t if the word is found
     */
    public boolean search(String word) {
        Trie curTrie = this;
        for (char c : word.toCharArray()) {
            int thisIndex = c - 'a';
            if (curTrie.children[thisIndex] == null) {
                return false;
            }
            curTrie = curTrie.children[thisIndex];
        }
        return curTrie.isWord;
    }

    /**
     * search the Trie to find the given word
     * does not rely on the marker at the end to see if the word
     * (or just a prefix) was added -  prefix is good enough
     *
     * @param prefix
     * @return t if the prefix is found
     */
    public boolean startsWith(String prefix) {
        Trie curTrie = this;
        for (char c : prefix.toCharArray()) {
            int thisIndex = c - 'a';
            if (curTrie.children[thisIndex] == null) {
                return false;
            }
            curTrie = curTrie.children[thisIndex];
        }
        return true;
    }
}
