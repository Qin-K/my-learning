import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2019-12-03
 */
public class Test455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = g.length - 1;
        int p2 = s.length - 1;

        int cnt = 0;
        while (p1 >= 0 && p2 >= 0) {
            if (s[p2] < g[0]) {
                break;
            }
            if (s[p2] >= g[p1]) {
                cnt++;
                p2--;
                p1--;
            } else {
                p1--;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] g = {3, 4, 5};
        int[] s = {2, 3, 4};
        int res = new Test455().findContentChildren(g, s);
        System.out.println(res);
    }
}
