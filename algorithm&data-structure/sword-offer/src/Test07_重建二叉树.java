/**
 * @author Qin Kai
 * @date 2019-11-24
 */
public class Test07_重建二叉树 {

    class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            if (pre == null || pre.length < 1) {
                return null;
            }

            TreeNode node = new TreeNode(pre[0]);
            int inIndex = -1;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == pre[0]) {
                    inIndex = i;
                }
            }

            if (inIndex == 0) {
                node.left = null;
            } else {
                int[] nPre = new int[inIndex];
                int[] nIn = new int[nPre.length];
                System.arraycopy(pre, 1, nPre, 0, nPre.length);
                System.arraycopy(in, 0, nIn, 0, nIn.length);
                node.left = reConstructBinaryTree(nPre, nIn);
            }

            if (inIndex == in.length - 1) {
                node.right = null;
            } else {
                int[] nPre = new int[in.length - 1 - inIndex];
                int[] nIn = new int[nPre.length];

                System.arraycopy(pre, inIndex + 1, nPre, 0, nPre.length);
                System.arraycopy(in, inIndex + 1, nIn, 0, nIn.length);
                node.right = reConstructBinaryTree(nPre, nIn);
            }

            return node;
        }
    }

    public static void main(String[] args) {
        Test07_重建二叉树 test = new Test07_重建二叉树();
        int[] prev = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = test.new Solution().reConstructBinaryTree(prev  ,in);
        prevOrder(root);
    }

    private static void prevOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        prevOrder(node.left);
        prevOrder(node.right);
    }
}
