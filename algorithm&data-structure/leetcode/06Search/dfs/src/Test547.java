/**
 * @author Qin Kai
 * @date 2019-12-11
 */
public class Test547 {
    private int N;
    private boolean[] visited;
    public int findCircleNum(int[][] M) {
        if (M == null || M.length <= 0) {
            return 0;
        }
        N = M.length;
        int cnt = 0;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                cnt++;
                visited[i] = true;
                dfs(M, i);
            }
        }
        return cnt;
    }

    private void dfs(int[][] M, int i) {

        for (int j = 0; j < N; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] M = {{1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}};
        int[][] M = {{1,0,0,1},
                     {0,1,1,0},
                     {0,1,1,1},
                     {1,0,1,1}};
        int res = new Test547().findCircleNum(M);
        System.out.println(res);
    }
}
