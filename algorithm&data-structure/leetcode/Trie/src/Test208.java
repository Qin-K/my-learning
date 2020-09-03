import java.util.HashMap;
import java.util.Map;

/**
 * 实现 Trie (前缀树)
 * @author Qin Kai
 * @date 2019-11-03
 */
class Trie {

    private MyTrie trie;

    /** Initialize your data structure here. */
    public Trie() {
        trie = new MyTrie();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        trie.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return trie.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return trie.isPrefix(prefix);
    }
}
