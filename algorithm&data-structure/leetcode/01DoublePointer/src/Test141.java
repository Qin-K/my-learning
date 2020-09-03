/**
 * @author Qin Kai
 * @date 2019-12-01
 */
public class Test141 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test141 test = new Test141();
        ListNode node1 = test.new ListNode(1);
        ListNode node2 = test.new ListNode(2);
        node1.next = node2;
        node2.next = node1;
        System.out.println(test.hasCycle(node1));
    }
}
