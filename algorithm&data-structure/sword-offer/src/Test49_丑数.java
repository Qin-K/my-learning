import java.util.TreeSet;

/**
 * @author Qin Kai
 * @date 2020-02-09
 */
public class Test49_丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] dp = new int[index];
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }
        return dp[index - 1];
    }

    public int GetUglyNumber_Solution02(int index) {
        if (index <= 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                for (int k = 0; k < index; k++) {
                    if (i == 0 && j == 0 && k == 0) continue;
                    set.add((int) (Math.pow(2, i) * Math.pow(3, j) * Math.pow(5, k)));
                }
            }
        }
        for (int num : set) {
            if (--index == 0) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int res1 = new Test49_丑数().GetUglyNumber_Solution(100);
        int res2 = new Test49_丑数().GetUglyNumber_Solution02(100);
        System.out.println(res1 == res2);

    }
}
