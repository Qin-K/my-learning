import java.util.Arrays;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-27
 */
public class Test139 {
    // 1.记忆化dfs
    public boolean wordBreak(String s, List<String> wordDict) {
        mem = new Boolean[s.length() + 1];
        return dfs(s, 0, wordDict);
    }
    private Boolean[] mem;
    private boolean dfs(String s, int cur, List<String> wordDict) {
        if (cur == s.length()) {
            return true;
        }
        if (mem[cur] != null) {
            return mem[cur];
        }
        boolean res = false;
        for (String word : wordDict) {
            int nextIndex = cur + word.length();
            if (nextIndex > s.length()) continue;
            String substring = s.substring(cur, nextIndex);
            if (substring.equals(word)) {
                res = res || dfs(s, nextIndex, wordDict);
            }
        }
        mem[cur] = res;
        return res;
    }

    // 2.dp 完全背包，物品内层
    public boolean wordBreak02(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int index = i - word.length();
                if (index < 0) continue;
                String substring = s.substring(index, i);
                if (substring.equals(word)) {
                    dp[i] = dp[i] || dp[index];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("aaa", "bbb");
//        boolean res = new Test139().wordBreak("aaabbbb", wordDict);
        boolean res = new Test139().wordBreak02("aaabbb", wordDict);
        System.out.println(res);
    }

}
