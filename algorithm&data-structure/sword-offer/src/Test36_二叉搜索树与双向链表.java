import java.util.ArrayList;

/**
 * @author Qin Kai
 * @date 2020-02-03
 */
public class Test36_二叉搜索树与双向链表 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayList<TreeNode> nodes = new ArrayList<>();
        inOrder(pRootOfTree, nodes);
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode cur = nodes.get(i);
            if (i != nodes.size() - 1) {
                TreeNode next = nodes.get(i + 1);
                cur.right = next;
                next.left = cur;
            }
        }
        return nodes.get(0);
    }

    public void inOrder(TreeNode node, ArrayList<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        inOrder(node.left, nodes);
        nodes.add(node);
        inOrder(node.right, nodes);
    }
}
