import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2020-03-28
 */
public class Test66_构建乘积数组 {
    public int[] multiply(int[] A) {
        int len = A.length;
        int multi = 1;
        int[] B = new int[len];
        for (int i = 0; i < len; i++) {
            B[i] = multi;
            multi *= A[i];
        }

        multi = 1;
        for (int i = len - 1; i >= 0; i--) {
            B[i] *= multi;
            multi *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] res = new Test66_构建乘积数组().multiply(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(res));
    }
}
