import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Qin Kai
 * @date 2019-12-13
 */
public class Test47 {
    private boolean[] visited;
    private List<List<Integer>> res;
    private Set<List<Integer>> record;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        res = new ArrayList<>();
        record = new HashSet<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, int k, List<Integer> temp) {
        if (k == nums.length) {
            if (!record.contains(temp)) {
                record.add(new ArrayList<>(temp));
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                dfs(nums, k + 1, temp);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Test47().permuteUnique(new int[]{1, 1, 3});
        System.out.println(res);
    }
}
