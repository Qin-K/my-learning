import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-14
 */
public class Test39 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, 0,new ArrayList<>(), target);
        return res;
    }

    public void dfs(int[] candidates, int cur, int tempSum, List<Integer> tempList, int target) {
        if (tempSum == target) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (tempSum + candidates[i] > target) {
                break;
            }
            tempList.add(candidates[i]);
            dfs(candidates, i, tempSum + candidates[i], tempList, target);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> res = new Test39().combinationSum(candidates, 7);
        System.out.println(res);
    }

}
