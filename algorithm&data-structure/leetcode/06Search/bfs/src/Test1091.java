import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Qin Kai
 * @date 2019-12-10
 */
public class Test1091 {
    private class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(0, 0, 1);
        int n = grid.length;
        queue.add(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x, y = node.y, depth = node.depth;
            if (x == n - 1 && y == n - 1) {
                return depth;
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    if (x + i >= 0 && x + i < n &&
                            y + j >= 0 && y + j < n &&
                            grid[x + i][y + j] == 0) {
                        Node next = new Node(x + i, y + j, depth + 1);
                        queue.add(next);
                        grid[x + i][y + j] = 1;
                    }

                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
//        int[][] grid = {{1, 1, 0, 1},
//                {1, 0, 1, 0},
//                {1, 1, 1, 1},
//                {1, 0, 1, 1}};
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};

        int res = new Test1091().shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}
