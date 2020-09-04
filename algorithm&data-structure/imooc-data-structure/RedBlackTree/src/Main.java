/**
 * @author Qin Kai
 * @date 2019-11-04
 */
public class Main {
    public static void main(String[] args) {
        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (int i = 0; i < 10; i++) {
            rbTree.add(i + 1, i);
        }
        System.out.println(rbTree.getSize());
    }
}
