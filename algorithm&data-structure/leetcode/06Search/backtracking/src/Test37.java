/**
 * @author Qin Kai
 * @date 2019-12-16
 */
public class Test37 {
    private boolean flag = false;
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private void dfs(char[][] board, int x, int y) {
        if (flag) return;
        if (x == 9) {
            flag = true;
            return;
        }
        int nextX = x + y / 8;
        int nextY = (y + 1) % 9;
        if (board[x][y] != '.') {
            dfs(board, nextX, nextY);
            return;
        }
        for (char c = '1'; c <= '9' && !flag; c++) {
            if (check(board, x, y, c)) {
                board[x][y] = c;
                dfs(board, nextX, nextY);
                if (!flag) {
                    board[x][y] = '.';
                }
            }
        }
    }

    public boolean check(char[][] board, int x, int y, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num || board[x][i] == num) {
                return false;
            }
        }
        x = x - x % 3;
        y = y - y % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {       {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        Test37 test = new Test37();
        test.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(board[i]));
        }
    }
}
