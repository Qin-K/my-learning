/**
 * @author Qin Kai
 * @date 2019-12-08
 */
public class Test69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r -l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int res = new Test69().mySqrt(2147395599);
        System.out.println(res);
    }
}
