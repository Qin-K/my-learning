/**
 * @author Qin Kai
 * @date 2019-10-29
 */
public class Main {
    public static void main(String[] args) {
//        BSTSet<Integer> set = new BSTSet<>();
        Set<Integer> set = new LinkedListSet<Integer>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(3);
        System.out.println(set.getSize());
        set.remove(3);
        System.out.println(set.getSize());
    }
}
