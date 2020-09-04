import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-11
 */
public class Test417_myBad {
    private int m;
    private int n;
    private boolean flag1; // 是否流进太平洋
    private boolean flag2; // 是否流进大西洋
    private boolean[][] visited;
    private int[][] derections = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length <= 0) {
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j);
                if (flag1 && flag2) {
                    res.add(Arrays.asList(i, j));
                }
                flag1 = flag2 = false;
                visited = new boolean[m][n];
            }
        }

        return res;
    }

    public void dfs(int[][] matrix, int x, int y) {
        visited[x][y] = true;
        for(int[] d : derections) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX < 0 || nextY < 0) {
                flag1 = true;
            } else if (nextX >= m || nextY >= n) {
                flag2 = true;
            } else {
                if (matrix[nextX][nextY] <= matrix[x][y] && !visited[nextX][nextY]) {
                    dfs(matrix, nextX, nextY);
                }
            }

            if (flag1 && flag2) return;
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
        List<List<Integer>> res = new Test417_myBad().pacificAtlantic(matrix);
        System.out.println(res);
    }
}
