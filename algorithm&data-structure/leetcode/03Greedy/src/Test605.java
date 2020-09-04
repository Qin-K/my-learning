/**
 * @author Qin Kai
 * @date 2019-12-06
 */
public class Test605 {
    public boolean canPlaeFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length  < n) {
            return false;
        }
        int cnt = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int prev = i == 0 ? 0 : i - 1;
            int next = i == len - 1 ? len : i + 1;
            if (flowerbed[prev] == 0 && flowerbed[next] == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0};
//        boolean res = new Test605().canPlaeFlowers(flowerbed, 1);
        boolean res = new Test605().canPlaeFlowers(flowerbed, 1);
        System.out.println(res);
    }
}
