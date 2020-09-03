import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Qin Kai
 * @date 2020-01-09
 */
public class Test650 {
    private class Node {
        int pasteLen; // 状态
        int len;
        int deep;
        Node(int len, int deep, int pasteLen) {
            this.len = len;
            this.deep = deep;
            this.pasteLen = pasteLen;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            Node o = (Node)obj;
            return this.len == o.len && this.pasteLen == o.pasteLen;
        }

        @Override
        public int hashCode() {
            return this.len * 1000 + pasteLen;
        }
    }

    public int minSteps(int n) {
        if (n == 1) return 0;
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        Node node = new Node(1, 1, 1);// copy
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            int pasteLen = p.pasteLen;
            int len = p.len;
            int deep = p.deep;
            if (len == n) {
                return deep;
            }
            if (pasteLen == len) { // copy状态只能paste
                Node t = new Node(len + pasteLen, deep + 1, pasteLen);
                if (!set.contains(t)) {
                    queue.offer(t);
                    set.add(t);
                }
            } else {
                Node t = new Node(len, deep + 1, len);
                if (!set.contains(t)) {
                    queue.offer(t); // copy
                    set.add(t);
                }

                t = new Node(len + pasteLen, deep + 1, pasteLen);
                if (!set.contains(t)) {
                    queue.offer(t); // copy
                    set.add(t);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = new Test650().minSteps(3);
        System.out.println(res);
    }
}
