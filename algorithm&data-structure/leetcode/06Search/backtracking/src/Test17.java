import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-13
 */
public class Test17 {
    private List<String> res;
    private String[] chars = {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
    };
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        dfs(digits,0, "");
        return res;
    }

    private void dfs(String digits, int k, String str) {
        if (k == digits.length()) {
            res.add(str);
            return;
        }

        String s = chars[digits.charAt(k) - '2'];
        for (int i = 0; i < s.length(); i++) {
            dfs(digits, k + 1, str.concat(String.valueOf(s.charAt(i))));
        }
    }

    public static void main(String[] args) {
        List<String> res = new Test17().letterCombinations("23");
        System.out.println(res);
    }
}
