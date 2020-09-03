/**
 * @author Qin Kai
 * @date 2020-03-28
 */
public class Test19_正则表达式匹配 {
    public boolean match(char[] str, char[] pattern) {
        return dfs(str, pattern, 0, 0);
    }

    private boolean dfs(char[] str, char[] pattern, int p1, int p2) {
        if (p1 == str.length) {
            if (p2 == pattern.length) {
                return true;
            }
            if (pattern.length - p2 == 1 || pattern[p2 + 1] != '*') {
                return false;
            } else {
                return dfs(str, pattern, p1, p2 + 2);
            }

        }

        if (p2 == pattern.length) {
            return false;
        }


        if (p2 + 1 < pattern.length && pattern[p2 + 1] == '*') {
            if (str[p1] != pattern[p2] && pattern[p2] != '.') { // 出现一次
                return dfs(str, pattern, p1, p2 + 2);
            }

            while ((p1 < str.length) && (str[p1] == pattern[p2] || pattern[p2] == '.')) {
                if (dfs(str, pattern, p1, p2 + 2) || dfs(str, pattern, ++p1, p2 + 2)) {
                    return true;
                }
            }
        } else if (str[p1] == pattern[p2] ||
                ((str[p1] != pattern[p2]) && pattern[p2] == '.')) {
            return dfs(str, pattern, p1 + 1, p2 + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        boolean res = new Test19_正则表达式匹配().match("a".toCharArray(), ".*".toCharArray());
        System.out.println(res);
    }
}
