import java.util.HashSet;
import java.util.Set;

/**
 * @author Qin Kai
 * @date 2020-02-09
 */
public class Test52_两个链表的第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = pHead1;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        p = pHead2;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
