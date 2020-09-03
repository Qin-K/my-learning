/**
 * @author Qin Kai
 * @date 2019-10-29
 */
public class Main {

    public static void main(String[] args) {
//        Map<Integer, Integer> map = new LinkedListMap<>();
        Map<Integer, Integer> map = new BSTMap<>();
        map.add(1, 3);
        map.add(1,2);
        System.out.println(map.getSize());
        System.out.println(map.get(1));
    }
}
