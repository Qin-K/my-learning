/**
 * @author Qin Kai
 * @date 2019-12-01
 */
public class Test167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] == target) {
                return new int[]{index1 + 1, index2 + 1};
            } else if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] res = new Test167().twoSum(numbers, target);
        System.out.println("index1=" + res[0] + " index2=" + res[1]);
    }
}
