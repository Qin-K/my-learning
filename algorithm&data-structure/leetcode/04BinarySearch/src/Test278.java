/**
 * @author Qin Kai
 * @date 2019-12-08
 */
public class Test278 {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static void main(String[] args) {
        int res = new Test278().firstBadVersion(5);
        System.out.println(res);
    }
}
