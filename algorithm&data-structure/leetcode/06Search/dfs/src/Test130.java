import java.util.Scanner;

/**
 * @author Qin Kai
 * @date 2019-12-11
 */
public class Test130 {
    private int m;
    private int n;

    public void solve(char[][] board) {
        if (board == null || board.length <= 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 ||
                            j == 0 || j == n - 1) {
                        dfs(board, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'Y';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[m][];
        for (int i = 0; i < m; i++) {
            board[i] = sc.nextLine().replace(" ", "").toCharArray();
        }
        new Test130().solve(board);
        StringBuilder sb = new StringBuilder();
        for (char[] arr : board) {
            sb.append(new String(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
