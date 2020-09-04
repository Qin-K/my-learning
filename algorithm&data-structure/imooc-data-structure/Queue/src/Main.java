/**
 * @author Qin Kai
 * @date 2019-10-27
 */
public class Main {

    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            System.out.println(queue);
//
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }
//
//        System.out.println(queue.getFront());
//        System.out.println(queue.isEmpty());
//        System.out.println(queue.getSize());
//        System.out.println(((ArrayQueue<Integer>) queue).getCapacity());

//        Queue<Integer> queue = new LoopQueue<>();
        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);;
        }
        System.out.println(queue);

        for (int i = 0; i < 15; i++) {
            queue.dequeue();
        }

        System.out.println(queue);
    }

}
