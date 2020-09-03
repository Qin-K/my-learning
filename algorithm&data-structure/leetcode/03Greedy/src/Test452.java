import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2019-12-04
 */
public class Test452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }

        Arrays.sort(points, (a1, a2) -> a1[1] - a2[1]);

        int cnt = 1;
        int[] prev = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= prev[1]) {
                continue;
            }
            cnt++;
            prev = points[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        int res = new Test452().findMinArrowShots(points);
        System.out.println(res);
    }
}
