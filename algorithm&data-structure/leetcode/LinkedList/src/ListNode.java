/**
 * @author Qin Kai
 * @date 2019-10-27
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    // 使用arr创建链表，当前ListNode为链表头结点
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while(cur != null) {
            sb.append(cur.val).append("->");
            cur = cur.next;
        }
        sb.append("NULL");

        return sb.toString();
    }
}
