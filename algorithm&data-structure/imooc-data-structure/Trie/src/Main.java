/**
 * @author Qin Kai
 * @date 2019-11-03
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("hello");
        trie.add("world");
        trie.add("thank");
        trie.add("you");
        System.out.println(trie.getSize());
        System.out.println(trie.contains("hello"));
    }
}
