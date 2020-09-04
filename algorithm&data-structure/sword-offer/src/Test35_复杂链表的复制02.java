/**
 * @author Qin Kai
 * @date 2020-02-03
 */
public class Test35_复杂链表的复制02 {
    public RandomListNode Clone(RandomListNode pHead) {
        // 复制旧链表中每个节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode next = cur.next;
            RandomListNode clone = new RandomListNode(cur.label);
            cur.next = clone;
            clone.next = next;
            cur = next;
        }

        // 修改新复制节点的random指针
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            clone.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // 分割链表
        cur = pHead;
        RandomListNode newHead = pHead.next;
        while (cur != null) {
            RandomListNode clone = cur.next;
            cur.next = clone.next;
            clone.next = clone.next == null ? null : clone.next.next;
            cur = cur.next;

        }
        return newHead;
    }


    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node2;
        RandomListNode clone = new Test35_复杂链表的复制02().Clone(node1);
    }
}
