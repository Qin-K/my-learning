import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-13
 */
public class Test257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, String.valueOf(root.val));
        return res;
    }

    private void dfs(TreeNode node, String path) {
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        if (node.left != null) {
            String p = path + "->" + node.left.val;
            dfs(node.left, p);
        }
        if (node.right != null) {
            path = path + "->" + node.right.val;
            dfs(node.right, path);
        }
    }

    public static void main(String[] args) {
        Test257 test = new Test257();
        TreeNode root = test.new TreeNode(1);
        TreeNode node1 = test.new TreeNode(2);
        TreeNode node2 = test.new TreeNode(5);
        TreeNode node3 = test.new TreeNode(3);

        root.left = node1;
        root.right = node3;
        node1.right = node2;
        List<String> res = test.binaryTreePaths(root);
        System.out.println(res);
    }

}
