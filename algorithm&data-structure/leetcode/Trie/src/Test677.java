import java.util.HashMap;
import java.util.Map;

class MapSum {

    private class Node {
        private int val;
        private Map<Character, Node> next;
        public Node(int val) {
            this.val = val;
            next = new HashMap<>();
        }
        public Node() {
            this(0);
        }
    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int sum = node.val;
        for (Map.Entry<Character, Node> entry : node.next.entrySet()) {
            sum += sum(entry.getValue());
        }

        return sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        int sum = mapSum.sum("ap");
        System.out.println(sum);
        mapSum.insert("app", 2);
        sum = mapSum.sum("ap");
        System.out.println(sum);
    }

}