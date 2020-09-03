import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-16
 */
public class Test51 {
    private int n;
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        dfs(board, 0);
        return res;
    }

    private void dfs(char[][] board, int row) {
        if (row == n) {
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tempList.add(new String(board[i]));
            }
            res.add(tempList);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(board, row, col)) {
                board[row][col] = 'Q';
                dfs(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean check(char[][] board, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (j == y) return false;
                if (Math.abs(x - i) == Math.abs(y - j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new Test51().solveNQueens(4);
        System.out.println(res);
    }
}
