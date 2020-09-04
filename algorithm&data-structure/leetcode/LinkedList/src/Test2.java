/**
 * @author Qin Kai
 * @date 2019-11-22
 */
public class Test2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            int t = l1.val + l2.val; // 和
            int p = t / 10;
            ListNode head = new ListNode(t % 10);
            ListNode node = head;
            while (n1 != null && n2 != null) {
                t = n1.val + n2.val + p;
                node.next = new ListNode(t % 10);
                p = t / 10;
                n1 = n1.next;
                n2 = n2.next;
                node = node.next;
            }
            while (n1 != null) {
                t = n1.val + p;
                node.next = new ListNode(t % 10);
                p = t / 10;
                n1 = n1.next;
                node = node.next;
            }

            while (n2 != null) {
                t = n2.val + p;
                node.next = new ListNode(t % 10);
                p = t / 10;
                n2 = n2.next;
                node = node.next;
            }

            if (p != 0) {
                node.next = new ListNode(p);
            }

            return head;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        ListNode node = new Test2().new Solution().addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
