/**
 * @author Qin Kai
 * @date 2019-12-01
 */
public class Test663 {
    public boolean judgeSquareSum(int c) {
        int p1 = 0;
        int p2 = (int) Math.sqrt(c);
        while (p1 <= p2) {
            int s = p1 * p1 + p2 * p2;
            if (s == c) {
                return true;
            } else if (s < c) {
                p1++;
            } else {
                p2--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean res = new Test663().judgeSquareSum(2147482647);
        System.out.println(res);
    }
}
