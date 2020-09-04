/**
 * @author Qin Kai
 * @date 2019-12-16
 */
public class Test37_2 {
    private boolean[][] rowsUsed = new boolean[9][10];
    private boolean[][] colsUsed = new boolean[9][10];
    private boolean[][] cubesUsed = new boolean[9][10];
    private boolean flag = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowsUsed[i][num] = true;
                    colsUsed[j][num] = true;
                    cubesUsed[cubeNum(i, j)][num] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private void dfs(char[][] board, int x, int y) {
        if (flag) return;
        if (x == 9) {
            flag = true;
            return;
        }
        int nextX = y == 8 ? x + 1 : x;
        int nextY = y == 8 ? 0 : y + 1;
        if (board[x][y] != '.') {
            dfs(board, nextX, nextY);
            return;
        }
        for (char c = '1'; c <= '9' && !flag; c++) {
            int num = c - '0';
            int cubeNum = cubeNum(x, y);
            if (rowsUsed[x][num] || colsUsed[y][num] || cubesUsed[cubeNum][num]) {
                continue;
            }
            rowsUsed[x][num] = colsUsed[y][num] = cubesUsed[cubeNum][num] = true;
            board[x][y] = c;
            dfs(board, nextX, nextY);
            if (!flag) {
                board[x][y] = '.';
                rowsUsed[x][num] = colsUsed[y][num] = cubesUsed[cubeNum][num] = false;
            }
        }
    }


    public int cubeNum(int x, int y) {
        int r = x / 3;
        int c = y / 3;
        return r * 3 + c;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Test37_2 test = new Test37_2();
        test.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(board[i]));
        }
    }
}
