/**
 * @author Qin Kai
 * @date 2019-10-31
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4};
        SegementTree<Integer> segTree = new SegementTree<>(nums, (a, b) -> a + b);
        System.out.println(segTree);
        System.out.println(segTree.query(1, 3));
    }
}
