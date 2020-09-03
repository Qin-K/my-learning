import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-05
 */
public class Test406 {
    // bad
    public int[][] reconstructQueue01(int[][] people) {
        int[][] res = new int[people.length][];

        Arrays.sort(people, (a1, a2) -> a1[0] - a2[0]);

        int cur = 0;
        for (int[] arr : people) {
            int index = 0;
            for (int i = 0; i < res.length; i++) {
                if (res[i] == null &&
                        (cur == people.length - 1 || index == arr[1])) {
                    res[i] = arr;
                    break;
                }
                if (res[i] == null || res[i][0] == arr[0]) {
                    index++;
                }
            }
            cur++;
        }

        return res;
    }

    public int[][] reconstructQueue02(int[][] people) {

        Arrays.sort(people, (a1, a2) ->  {
            return a1[0] == a2[0] ? a1[1] - a2[1] : a2[0] - a1[0];
        });

        List<int[]> res = new ArrayList<>();
        for (int[] arr : people) {
            res.add(arr[1], arr);
        }

        return res.toArray(new int[0][]);
    }
    

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] res = new Test406().reconstructQueue02(people);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int[] arr : res) {
            sb.append(Arrays.toString(arr));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }
}
