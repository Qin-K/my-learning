import java.util.*;

/**
 * @author Qin Kai
 * @date 2019-12-26
 */
public class Test322 {
    // 1.BFS
    private class Node {
        int sum;
        int deep;
        public Node (int sum, int deep) {
            this.sum = sum;
            this.deep = deep;
        }
    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int coin : coins) {
            if (coin <= amount) {
                set.add(coin);
                Node node = new Node(coin, 1);
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int sum = node.sum;
            int deep = node.deep;
            if (sum == amount) {
                int s = 0;
                return deep;
            }
            for (int coin : coins) {
                int tempSum = sum + coin;
                if (tempSum <=  amount && !set.contains(tempSum)) {
                    set.add(tempSum);
                    queue.offer(new Node(tempSum, deep + 1));
                }
            }
        }
        return -1;
    }


    // 2.DFS超时
    private int min = -1;
    public int coinChange02(int[] coins, int amount) {
        dfs(coins, 0, amount, 0);
        return min;
    }
    private void dfs(int[] coins, int cur, int amount, int count) {
        if (amount < 0 || (count >= min && min != -1)) {
            return;
        }
        if (amount == 0 || cur >= coins.length) {
            if (amount == 0) {
                min = count;
            }
            return;
        }

        for (int i = 0; i <= amount / coins[cur]; i++) {
            dfs(coins, cur + 1, amount - i * coins[cur], count + i);
        }
    }

    // 3.DP 完全背包
    public int coinChange03(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int coin = coins[i - 1];
                dp[i][j] = dp[i - 1][j];
                if (coin == j) {
                    dp[i][j] = 1;
                } else if (coin <= j) {
                    if (dp[i][j - coin] != 0 && dp[i - 1][j] != 0) {
                        dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
                    } else if(dp[i][j - coin] != 0) {
                        dp[i][j] = dp[i][j - coin] + 1;
                    }
                }
            }
        }
        return dp[n][amount] == 0 ? -1 : dp[n][amount];
    }

    // 4.DP 完全背包压缩体积
    public int coinChange04(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { // 完全背包正序
                if (coin == i) {
                    dp[i] = 1;
                    continue;
                }
                if (dp[i] != 0 && dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                } else if (dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
//        int res = new Test322().coinChange(coins, 100);
//        int res = new Test322().coinChange02(coins, 100);
        int res = new Test322().coinChange03(coins, 11);
        System.out.println(res);
    }
}
