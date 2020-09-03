/**
 * @author Qin Kai
 * @date 2019-12-13
 */
public class Test79 {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;
    private int m;
    private int n;
    private boolean res;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    dfs(board, word, i, j, 0);
                    visited[i][j] = false;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] board, String word, int x, int y, int k) {
        if (res) return;
        if (k == word.length() - 1) {
            res = true;
            return;
        }
        for (int[] d : directions) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                continue;
            }
            if (board[nextX][nextY] == word.charAt(k + 1) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(board, word, nextX, nextY, k + 1);
                visited[nextX][nextY] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        boolean res = new Test79().exist(board, "ABCCEE");
        System.out.println(res);
    }
}
