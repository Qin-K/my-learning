import java.util.*;

/**
 * @author Qin Kai
 * @date 2019-12-10
 */
public class Test127 {
    private class Node {
        String s;
        int depth;

        public Node(String s, int depth) {
            this.s = s;
            this.depth = depth;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(beginWord, 1));
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int depth = cur.depth;
            if (cur.s.equals(endWord)) {
                return depth;
            }
            for (String word : wordList) {
                if (!set.contains(word) && check(cur.s, word)) {
                    Node node = new Node(word, depth + 1);
                    queue.offer(node);
                    set.add(word);
                }
            }
        }
        return 0;
    }

    /**
     * 判断只改变一个字母s能否到word
     * @param s
     * @param word
     * @return
     */
    private boolean check(String s, String word) {
        boolean flag = false;
        for (int i = 0; i < s.length() && i < word.length(); i++) {
            if (s.charAt(i) != word.charAt(i)) {
                if (flag) return false;
                flag = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int res = new Test127().ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
