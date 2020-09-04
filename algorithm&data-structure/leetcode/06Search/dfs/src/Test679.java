/**
 * @author Qin Kai
 * @date 2019-12-11
 */
public class Test679 {
    private int max = 0;
    private int cnt = 0;
    private int m;
    private int n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    if (cnt > max) {
                        max = cnt;
                    }
                    cnt = 0;
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
            return;
        }
        grid[x][y] = 0;
        cnt++;
        dfs(grid, x - 1, y); // 上
        dfs(grid, x + 1, y); // 下
        dfs(grid, x, y - 1); // 左
        dfs(grid, x, y + 1); // 右

    }

    public static void main(String[] args) {
//        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//        };
        
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};

        int res = new Test679().maxAreaOfIsland(grid);
        System.out.println(res);
    }
}