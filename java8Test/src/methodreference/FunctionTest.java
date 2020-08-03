package methodreference;

import java.util.function.Function;

/**
 * @author qinkai
 * @date 2020-07-10 14:47:06
 **/
public class FunctionTest {
    public int add(int[] arr) {
        return arr[0] + arr[1];
    }
    public static void main(String[] args) {
        Function<int[], Integer> function = new FunctionTest()::add;
        Integer result = function.apply(new int[]{1, 2});
        System.out.println(result);
    }
}
