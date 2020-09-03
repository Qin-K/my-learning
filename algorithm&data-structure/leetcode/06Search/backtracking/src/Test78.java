import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-16
 */
public class Test78 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int k, List<Integer> tempList) {
        if (k == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        // 选
        tempList.add(nums[k]);
        dfs(nums, k + 1, tempList);
        tempList.remove(tempList.size() - 1);
        // 不选
        dfs(nums, k + 1, tempList);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Test78().subsets(nums);
        System.out.println(res);
    }
}
