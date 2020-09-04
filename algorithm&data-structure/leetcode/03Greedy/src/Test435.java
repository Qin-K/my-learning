import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-04
 */
public class Test435 {
    private class Interval {
        int begin;
        int end;
        Interval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
    public int eraseOverlapIntervals01(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        List<Interval> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }

        list.sort((i1, i2) -> {
            return i1.end - i2.end;
        });

        Interval prev = list.get(0);
        int cnt = 0;
        for (int i = 1; i < list.size(); i++) {
            Interval cur = list.get(i);
            if (cur.begin < prev.end) {
                cnt++;
                continue;
            }
            prev = cur;
        }

        return cnt;
    }

    public int eraseOverlapIntervals02(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, (a1, a2) -> a1[1] - a2[1]);

        int[] prev = intervals[0];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                cnt++;
                continue;
            }
            prev = intervals[i];
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        int res = new Test435().eraseOverlapIntervals02(intervals);
        System.out.println(res);
    }
}
