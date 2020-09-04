import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Qin Kai
 * @date 2020-02-03
 */
public class Test38_字符串的全排列 {
    private ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        dfs(0, str.toCharArray());
        Collections.sort(res, String::compareTo);
        return res;
    }

    private void dfs(int cur, char[] charArr) {
        if (cur == charArr.length) {
            res.add(String.valueOf(charArr));
            return;
        }
        for (int i = cur; i < charArr.length; i++) {
            if (i == cur || charArr[cur] != charArr[i]) {
                swap(charArr, cur, i);
                dfs(cur + 1, charArr);
                swap(charArr, cur, i);
            }
        }
    }

    private void swap(char[] charArr, int i, int j) {
        char c = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = c;
    }

    public static void main(String[] args) {
        ArrayList<String> res = new Test38_字符串的全排列().Permutation("abc");
        System.out.println(res);
    }
}
