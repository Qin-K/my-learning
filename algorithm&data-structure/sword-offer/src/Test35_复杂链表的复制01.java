import java.util.HashMap;
import java.util.Map;

/**
 * @author Qin Kai
 * @date 2020-02-03
 */
public class Test35_复杂链表的复制01 {
    /**
     * 使用Map存储新旧节点的映射关系，然后改变对应复制节点的next和random指向
     * @param pHead 待复制链表的头结点
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode cur = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        RandomListNode newHead = map.get(pHead);
        cur = pHead;
        while (cur != null) {
            RandomListNode cloneNode = map.get(cur);
            cloneNode.next = map.get(cur.next);
            cloneNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return newHead;
    }
}
