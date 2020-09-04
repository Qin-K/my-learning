import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-09
 */
public class Test241 {
    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (isOperator(input.charAt(i))) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, len));
                for (int l : left) {
                    for (int r : right) {
                        list.add(calculate(input.charAt(i) , l, r));
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.parseInt(input));
        }

        return list;
    }

    private Integer calculate(char c, int nums1, int nums2) {
        switch (c) {
            case '+':
                return nums1 + nums2;
            case '-':
                return nums1 - nums2;
            case '*':
                return nums1 * nums2;
            default:
                return -1;
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        List<Integer> res = new Test241().diffWaysToCompute(input);
        System.out.println(res);
    }
}
