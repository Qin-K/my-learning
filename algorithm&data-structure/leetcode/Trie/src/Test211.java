import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    private class Node {
        boolean isWord;
        Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }

            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
//        return search(root, word);
    }

    private boolean search(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Map.Entry<Character, Node> entry : node.next.entrySet()) {
                boolean flag = search(entry.getValue(), word, index + 1);
                if (flag) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.next.get(c) == null) {
                return false;
            }

            return search(node.next.get(c), word, index + 1);
        }
    }

//    private boolean search(Node node, String word) {
//        if (word.length() == 0) {
//            return node.isWord;
//        }
//
//        Node cur = node;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (c == '.') {
//                for (Map.Entry<Character, Node> entry : cur.next.entrySet()) {
//                    if (search(entry.getValue(), word.substring(i + 1))) {
//                        return true;
//                    }
//                }
//
//                return false;
//            } else {
//                if (cur.next.get(c) == null) {
//                    return false;
//                } else {
//                    cur = cur.next.get(c);
//                }
//            }
//        }
//
//        return cur.isWord;
//    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        boolean res = wordDictionary.search("a.");
        System.out.println(res);
    }
}
