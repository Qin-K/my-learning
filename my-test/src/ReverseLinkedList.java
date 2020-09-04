/**
 * @author Qin Kai
 * @date 2019-11-20
 */
public class ReverseLinkedList {
    private static class Node {
        int val;
        Node next;

        Node (int val) {
            this.val = val;
        }
    }

    public static Node reverse(Node head) {
        Node temp = head;
        Node cur = head.next;
        Node p = cur.next;

        while (true) {
            cur.next = temp;
            temp = cur;
            cur = p;
            p = p.next;
            if (p == null) {
                cur.next = temp;
                break;
            }
        }

        head.next = null;

        return cur;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        head.next = node1;
        node1.next = node2;
        head = reverse(head);

        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
