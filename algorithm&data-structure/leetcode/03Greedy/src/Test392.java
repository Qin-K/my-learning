/**
 * @author Qin Kai
 * @date 2019-12-06
 */
public class Test392 {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        int sLen = s.length();
        int tLen = t.length();
        while (p1 < sLen && p2 < tLen) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == sLen;
    }

    // good
    public boolean isSubsequence02(String s, String t) {
        int lastIndex = -1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            lastIndex = t.indexOf(s.charAt(i), lastIndex + 1);
            if (lastIndex == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        boolean res = new Test392().isSubsequence("abc","ahbgdc");
        boolean res = new Test392().isSubsequence02("abc","ahbgdc");
        System.out.println(res);
    }
}
