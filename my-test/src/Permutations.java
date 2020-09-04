import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-14
 */
public class Permutations {
    private List<String> res = new ArrayList<>();

    public void dfs(char[] arr, int k) {
        if (k == arr.length - 1) {
            res.add(new String(arr));
            return;
        }

        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            dfs(arr, k + 1);
            swap(arr, i, k);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.dfs("123".toCharArray(), 0);
        System.out.println(p.res);
    }
}
