/**
 * @author Qin Kai
 * @date 2019-10-26
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr.toString());
        arr.addLast(10);
        arr.removeLast();
        arr.removeLast();
        System.out.println(arr.toString());
    }

}
