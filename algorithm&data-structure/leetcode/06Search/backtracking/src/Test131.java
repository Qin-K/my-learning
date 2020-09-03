import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-16
 */
public class Test131 {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int cur, List<String> tempList) {
        int len = s.length();
        if (cur == len) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = cur + 1; i <= len; i++) {
            String subString = s.substring(cur, i);
            if (isParlindrome(subString)) {
                tempList.add(subString);
                dfs(s, i, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public boolean isParlindrome(String s) {
        int i = 0;
        int len = s.length();
        while (i < (len / 2)) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new Test131().partition("aab");
        System.out.println(res);
    }
}
