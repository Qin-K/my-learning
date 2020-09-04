/**
 * 移除链表元素
 * @author Qin Kai
 * @date 2019-10-27
 */
public class Test203 {

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;

            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    /**
     * 使用虚拟头结点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return removeElements(head.next,val);
        }
        head.next = removeElements(head.next,val);
        return head;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        System.out.println(new Test203().removeElements(head, 6));
        System.out.println(new Test203().removeElements3(head, 6));
    }
}
