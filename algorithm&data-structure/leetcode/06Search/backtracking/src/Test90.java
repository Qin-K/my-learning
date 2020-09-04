import java.util.*;

/**
 * @author Qin Kai
 * @date 2019-12-16
 */
public class Test90 {
    private List<List<Integer>> res = new ArrayList<>();
    private Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int k, List<Integer> tempList) {
        if (k == nums.length) {
            List<Integer> list = new ArrayList<>(tempList);
            Collections.sort(list);
            if (!set.contains(list)) {
                set.add(list);
                res.add(list);
            }

            return;
        }
        tempList.add(nums[k]);
        dfs(nums, k + 1, tempList);
        tempList.remove(tempList.size() - 1);
        dfs(nums, k + 1, tempList);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = new Test90().subsetsWithDup(nums);
        System.out.println(res);
    }
}
