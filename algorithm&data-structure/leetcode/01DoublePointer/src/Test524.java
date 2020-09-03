import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-02
 */
public class Test524 {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (s1, s2) -> {
            if (s1.length() > s2.length()) {
                return -1;
            } else if (s1.length() < s2.length()) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        });
        for (String str : d) {
            if (s.length() < str.length()) {
                return "";
            }
            if (check(s, str)){
                return str;
            }
        }

        return "";
    }

    /**
     * 检查s2能不能通过s1删除部分字母形成
     * @param s1
     * @param s2
     * @return
     */
    public boolean check(String s1, String s2) {
        int p1 = 0;
        int p2 = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while (p2 < s2.length()) {
            // s1剩下的长度不够s2剩下的长度
            if (len1 - p1 < len2 - p2) {
                return false;
            }
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        s = "abpcplea", d = ["ale","apple","monkey","plea"]
        String s = "abpcplea";
        List<String> d = Arrays.asList("ale","apple","monkey","plea");
        String res = new Test524().findLongestWord(s, d);
        System.out.println(res);
    }

}
