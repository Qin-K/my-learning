import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-13
 */
public class Test93 {
    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() < 4) {
            return res;
        }
        dfs(s, 0, "", 0);
        return res;
    }

    private void dfs(String s, int index, String tempIp, int k) {
        if (k > 4) return;

        if (index == s.length()) {
            if (k == 4) {
                res.add(tempIp.substring(0, tempIp.length() - 1));
            }
            return;
        }

        if (s.charAt(index) == '0') {
            dfs(s, index + 1, tempIp.concat("0."), k + 1);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            int num = Integer.valueOf(s.substring(index, index + i));
            if (num > 255) break;
            dfs(s, index + i, tempIp.concat(String.valueOf(num).concat(".")), k + 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new Test93().restoreIpAddresses("1111");
        System.out.println(res);
    }
}
