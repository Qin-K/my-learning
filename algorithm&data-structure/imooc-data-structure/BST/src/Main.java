/**
 * @author Qin Kai
 * @date 2019-10-29
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 4, 3, 6, 8};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
        bst.preOrder();
        System.out.println();
        bst.remove(5);
        bst.preOrder();
    }

}
