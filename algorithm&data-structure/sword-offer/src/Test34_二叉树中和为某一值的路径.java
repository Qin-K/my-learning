import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Qin Kai
 * @date 2020-02-01
 */
public class Test34_二叉树中和为某一值的路径 {
    private ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        FindPath(new ArrayList<>(), root, target);
        Collections.sort(resList, (a, b) -> b.size() - a.size());
        return resList;
    }

    public void FindPath(ArrayList<Integer> path, TreeNode root,int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target - root.val == 0) {
                resList.add(new ArrayList<>(path));
            }
        } else {
            FindPath(path, root.left, target - root.val);
            FindPath(path, root.right, target - root.val);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(12);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        ArrayList<ArrayList<Integer>> res = new Test34_二叉树中和为某一值的路径().FindPath(node1, 22);
        System.out.println(res);
    }
}
