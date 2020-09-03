import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2019-10-31
 */
public class Test303 {

    static class NumArray {

        private interface Merger<E> {
            E merge(E a, E b);
        }

        private class SegementTree<E> {
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

        private SegementTree<Integer> segTree;

        public NumArray(int[] nums) {
            Integer[] tempArr = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                tempArr[i] = nums[i];
            }
            segTree = new SegementTree<>(tempArr, (a, b) -> a +b);
        }

        public int sumRange(int i, int j) {
            return segTree.query(i, j);
        }
    }

    static class NumArray2 {

        private int[] sums;
        public NumArray2(int[] nums) {
            sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sums[i] = nums[i];
                } else {
                    sums[i] = sums[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sums[j];
            }

            return sums[j] - sums[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
//        int result = new NumArray(nums).sumRange(2, 5);
        int result = new NumArray2(nums).sumRange(2, 5);
        System.out.println(result);
    }
}
