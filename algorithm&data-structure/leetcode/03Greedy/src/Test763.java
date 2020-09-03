import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-07
 */
public class Test763 {

    public List<Integer> partitionLabels(String S) {
        if (S == null) return new ArrayList<>();
        int len = S.length();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len;) {
            int right = S.lastIndexOf(S.charAt(i));

            for (int j = i; j < right; j++) {
                if (visited[S.charAt(j) - 'a']) continue;
                if (S.lastIndexOf(S.charAt(j)) > right) {
                    right = S.lastIndexOf(S.charAt(j));
                }
                visited[S.charAt(j) - 'a'] = true;
            }

            list.add(right - i + 1);
            i = right + 1;
        }

        return list;
    }

    public List<Integer> partitionLabels02(String S) {
        if (S == null) return new ArrayList<>();
        int len = S.length();
        List<Integer> list = new ArrayList<>();
        int[] lastIndexsOfChar = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndexsOfChar[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < len;) {
            int right = lastIndexsOfChar[S.charAt(i) - 'a'];

            for (int j = i; j < right; j++) {
                int lastIndex = lastIndexsOfChar[S.charAt(j) - 'a'];
                if (lastIndex > right) {
                    right = lastIndex;
                }
            }

            list.add(right - i + 1);
            i = right + 1;
        }

        return list;
    }

    public static void main(String[] args) {
//        String S = "ababcbacadefegdehijhklij";
        String S = "abcd";
        List<Integer> res = new Test763().partitionLabels02(S);
        System.out.println(res);
    }
}
