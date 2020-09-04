import java.util.HashMap;
import java.util.Map;

/**
 * @author Qin Kai
 * @date 2020-02-21
 */
public class Test56_数组中只出现一次的数字 {
    public void FindNumsAppearOnce01(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        boolean flag = false;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                if (!flag) {
                    num1[0] = entry.getKey();
                    flag = true;
                } else {
                    num2[0] = entry.getKey();
                }
            }
        }
    }
    public void FindNumsAppearOnce02(int [] array,int num1[] , int num2[]) {
        int xor1 = 0;
        for (int num : array) {
            xor1 ^= num;
        }
        int index = xor1 & -xor1;
        for (int num : array) {
            if ((index & num) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 4, 4, 5};
        new Test56_数组中只出现一次的数字().FindNumsAppearOnce02(array, new int[]{0}, new int[]{0});
    }
}
