import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2020-02-21
 */
public class Test57_和为S的两个数 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int left = 0;
        int right = array.length - 1;
        int[] resArr = new int[2];
        int minMultiply = Integer.MAX_VALUE;
        while (left < right) {
            if (array[left] + array[right] == sum){
                if (array[left] * array[right] < minMultiply) {
                    resArr[0] = array[left];
                    resArr[1] = array[right];
                    minMultiply = array[left] * array[right];
                }
                left++;
                right--;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        return new ArrayList<>(Arrays.asList(resArr[0], resArr[1]));
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4 ,5 ,6};
        ArrayList<Integer> res = new Test57_和为S的两个数().FindNumbersWithSum(array, 8);
        System.out.println(res);
    }
}
