/**
 * @author Qin Kai
 * @date 2020-01-29
 */
public class Test26_树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            if (isSameTree(root1, root2)) {
                return true;
            }
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(2);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;

        node5.left = node6;
        node5.right = node7;
        System.out.println(new Test26_树的子结构().HasSubtree(node1, node5));
    }
}
