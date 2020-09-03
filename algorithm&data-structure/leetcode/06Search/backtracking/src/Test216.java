import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-14
 */
public class Test216 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n, new ArrayList<>());
        return res;
    }

    private void dfs(int cur, int k, int n, List<Integer> tempList) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(tempList));
            }
            return;
        }

        for (int i = cur; i <= 9; i++) {
            if (cur > n) break;
            tempList.add(i);
            dfs(i + 1, k - 1, n - i, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Test216().combinationSum3(3, 7);
        System.out.println(res);
    }
}
