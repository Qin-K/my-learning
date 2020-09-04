import java.util.Random;

/**
 * @author Qin Kai
 * @date 2019-10-26
 */
public class Main {

//    public static void main(String[] args) {
////        Stack<Integer> stack = new ArrayStack<>();
//        Stack<Integer> stack = new LinkedListStack<>();
//        for (int i = 0; i < 10; i++) {
//            stack.push(i);
//        }
//
//        System.out.println(stack);
//
//        stack.pop();
//        System.out.println(stack);
//    }

    public static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int optCount = 10000000;
        Stack<Integer> stack = new ArrayStack<>();
        double time1 = testStack(stack, optCount);
        System.out.println("ArrayStack Time: " + time1 + " s");

        stack = new LinkedListStack<>();
        double time2 = testStack(stack, optCount);
        System.out.println("LinkedListStack Time: " + time2 + " s");
    }
}
