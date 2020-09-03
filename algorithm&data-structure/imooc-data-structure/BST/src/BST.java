import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Qin Kai
 * @date 2019-10-29
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    private int size;

    private Node root;

    public BST() {
        size = 0;
        root = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//        } else {
//            add(root, e);
//        }
        root = add(root, e);
    }
//最开始个人理解有误，必须找到添加的节点的位置，然后新增父节点的孩子指向才能真的添加
//    private void add(Node node, E e) {
//        if (node == null) {
//            node = new Node(e); // 错误的写法，这里只是用node的局部变量指向了新添加的元素，但是整个树并没有添加这个节点。
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        }
//
//        if (e.compareTo(node.e) > 0) {
//            add(node.right, e);
//        }
//    }

//    private void add2(Node node, E e) {
//        if (node.left == null && e.compareTo(node.e) < 0) {
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//
//        if (node.right == null && e.compareTo(node.e) > 0) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.right, e);
//        }
//
//        if (e.compareTo(node.e) > 0) {
//            add(node.left, e);
//        }
//    }

    /**
     * 以node为根的BST中插入元素e
     *
     * @param node
     * @param e
     * @return 插入后的新根节点
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        }

        if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归的前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    public void postOrder() {
        preOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.e);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 最开始个人理解有误，必须找到删除节点的父节点，然后改变父节点的left指向才能真的删除
     * 删除最小值所在节点，并返回新的根节点
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        removeMax(root);
        return ret;
    }

    /**
     * 删除最大值所在节点，并返回新的根节点
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除二叉搜索树中指定节点
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根节点的二叉搜索树指定值的节点
     * @param node
     * @param e
     * @return 删除后新的根节点
     */
    private Node remove(Node node, E e) {
        if (node == null) { // 未找到
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                // 找到当前节点的右子树中最小节点，即比当前节点大的最小节点（后继）
                Node successor = minimum(node.right);
                // 用后继节点顶替待删除节点的位置
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null; // 删除当前节点

                return successor;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        String depthString = generateDepthString(depth);
        if (node == null) {
            res.append(depthString + "null\n");
            return;
        } else {
            res.append(depthString + node.e + "\n");
        }

        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }

        return sb.toString();
    }
}
