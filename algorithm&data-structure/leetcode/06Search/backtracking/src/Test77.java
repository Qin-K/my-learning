import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-14
 */
public class Test77 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k, new ArrayList<>());
        return res;
    }

    private void dfs(int cur, int n, int k, List<Integer> temp) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (n - cur + 1 < k) {
            return;
        }
        for (int i = cur; i <= n; i++) {
            temp.add(i);
            dfs(i + 1, n, k - 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Test77().combine(4, 2);
        System.out.println(res);
    }
}
