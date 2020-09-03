/**
 * @author Qin Kai
 * @date 2019-12-18
 */
public class Test303 {
    class NumArray {
        private int[] sums;
        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            int sum = 0;
            sums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i + 1] = sum;
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        NumArray numArray = new Test303().new NumArray(nums);
        int res = numArray.sumRange(1, 2);
        System.out.println(res);
    }
}
