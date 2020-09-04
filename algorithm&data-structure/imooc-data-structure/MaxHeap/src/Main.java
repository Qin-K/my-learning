/**
 * @author Qin Kai
 * @date 2019-10-31
 */
public class Main {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 6, 9, 3};
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(maxHeap.extractMax());
        }
    }
}
