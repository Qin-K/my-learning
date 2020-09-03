import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-11
 */
public class Test417 {
    private int m;
    private int n;
    private boolean[][] canP;
    private boolean[][] canA;
    private int[][] derections = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length <= 0) {
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        canP = new boolean[m][n];
        canA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, canP);
            dfs(matrix, i, n - 1, canA);
        }

        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, canP);
            dfs(matrix, m - 1, i, canA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canP[i][j] && canA[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix, int x, int y, boolean[][] can) {
        can[x][y] = true;
        for(int[] d : derections) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n ||
                    can[nextX][nextY] || matrix[nextX][nextY] < matrix[x][y]) {
                continue;
            }
            dfs(matrix, nextX, nextY, can);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> res = new Test417().pacificAtlantic(matrix);
        System.out.println(res);
    }
}
