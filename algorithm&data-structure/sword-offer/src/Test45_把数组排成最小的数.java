import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2020-02-06
 */
public class Test45_把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, (a, b) -> (a.concat(b).compareTo(b.concat(a))));
        StringBuilder sb = new StringBuilder();
        for (String s : strArr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {3, 32, 321};
        String res = new Test45_把数组排成最小的数().PrintMinNumber(numbers);
        System.out.println(res);
    }
}
