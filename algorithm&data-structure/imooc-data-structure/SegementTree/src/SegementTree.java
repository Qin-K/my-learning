import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2019-10-31
 */
public class SegementTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegementTree(E[] arr, Merger<E> merger) {
        data = Arrays.copyOf(arr,arr.length);
        tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;

        buildSegementTree(0, 0, data.length - 1);
    }

    private void buildSegementTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        int mid = l + ((r - l) >> 1);

        buildSegementTree(leftIndex, l, mid);
        buildSegementTree(rightIndex, mid + 1, r);

        tree[treeIndex] = this.merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 查询区间为[queryL, queryR]的结果
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length
                || queryR < 0 || queryR >= data.length
                || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        if (queryL > mid) {
            return query(rightTreeIndex,mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex,l, mid, queryL, queryR);
        } else {
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }
    }

    /**
     * 修改索引为index的值
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 修改线段树以treeIndex为根节点 index处的值
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index <= mid) {
            set(leftTreeIndex, l, mid, index, e);
        } else {
            set(rightTreeIndex, mid + 1, r, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }

            if (i != tree.length - 1) {
                res.append(",");
            }
        }

        res.append("]");
        return res.toString();
    }
}
