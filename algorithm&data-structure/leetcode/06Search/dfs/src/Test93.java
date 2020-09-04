import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2020-03-28
 */
public class Test93 {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return list;
        }
        dfs(s, 0, "", 0);
        return list;
    }

    private List<String> list = new ArrayList<>();

    private void dfs(String s, int cur, String temp, int count) {
        if (cur == s.length()) {
            if (count == 4) {
                list.add(temp.substring(0, temp.length() - 1));
            }
            return;
        }

        if (count >= 4) {
            return;
        }

        if (s.charAt(cur) == '0') {
            dfs(s, cur + 1, temp.concat("0."), count + 1);
        } else {
            for (int i = 1; i <= 3 && cur + i <= s.length(); i++) {
                int t = Integer.parseInt(s.substring(cur, cur + i));
                if (t <= 255) {
                    dfs(s, cur + i, temp.concat(t + "."), count + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = new Test93().restoreIpAddresses("25525511135");
        System.out.println(res);
    }
}
