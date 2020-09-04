/**
 * @author Qin Kai
 * @date 2019-10-31
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        int k = parent(arr.length - 1);
        for (int i = k; i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回完全二叉树中的数组表示，指定index元素的父节点
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't hava parent.");
        }

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 调整插入的元素（向上调整）
     *
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 获取堆中的最大值，并删除
     *
     * @return
     */
    public E extractMax() {
        E e = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    /**
     * 调整根元素所在位置（向下调整）
     *
     * @param k
     */
    private void siftDown(int k) {
        // 堆中有左孩子才进行调整
        while (leftChild(k) < data.getSize()) {
            int leftIndex = leftChild(k);
            int rightIndex = rightChild(k);
            int maxIndex = leftIndex;

            // k有右孩子，而且右孩子比左孩子大
            if (rightIndex < data.getSize()
                    && data.get(rightIndex).compareTo(data.get(leftIndex)) > 0) {
                maxIndex = rightIndex;
            } //data[maxIndex]是左右孩子大的一个

            // k比左孩子的最大值小，则要交换
            if (data.get(k).compareTo(data.get(maxIndex)) < 0) {
                data.swap(k, maxIndex);
                k = maxIndex;
            } else {
                break;
            }
        }
    }

    /**
     * 获取堆中的最大值，不删除
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("findMax failed, can not find max from an empty heap");
        }
        return data.get(0);
    }

    /**
     * 取出堆顶最大元素，将其替换为新元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
