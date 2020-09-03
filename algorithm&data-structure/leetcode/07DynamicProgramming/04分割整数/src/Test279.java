import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-19
 */
public class Test279 {
    public int numSquares(int n) {
        List<Integer> squaresList = generateSquaresList(n);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squaresList) {
                if (square > i) break;
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    /**
     * 创建一个1,4,...（小于等于n的平方数）
     * @param n
     * @return
     */
    private List<Integer> generateSquaresList(int n) {
        int square = 1;
        int diff = 3;
        List<Integer> squaresList = new ArrayList<>();
        while (square <= n) {
            squaresList.add(square);
            square += diff;
            diff += 2;
        }
        return squaresList;
    }

    public static void main(String[] args) {
        int res = new Test279().numSquares(4);
        System.out.println(res);
    }
}
