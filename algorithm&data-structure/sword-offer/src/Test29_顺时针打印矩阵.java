import java.util.ArrayList;

/**
 * @author Qin Kai
 * @date 2020-01-29
 */
public class Test29_顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                list.add(matrix[r1][i]);
            }

            for (int i = r1 + 1; i <= r2; i++) {
                list.add(matrix[i][c2]);
            }

            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    list.add(matrix[r2][i]);
                }
            }

            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    list.add(matrix[i][c1]);
                }
            }

            r1++;r2--;c1++;c2--;
        }

        return list;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4, 5}};
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        ArrayList<Integer> res = new Test29_顺时针打印矩阵().printMatrix(matrix);
        System.out.println(res);
    }
}
