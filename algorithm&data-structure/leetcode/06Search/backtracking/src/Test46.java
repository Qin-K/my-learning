import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-13
 */
public class Test46 {
    private boolean[] visited;
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int k, List<Integer> temp) {
        if (k == nums.length) {
            res.add(new ArrayList<>(temp));
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
        List<List<Integer>> res = new Test46().permute(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
