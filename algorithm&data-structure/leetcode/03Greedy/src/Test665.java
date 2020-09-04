/**
 * @author Qin Kai
 * @date 2019-12-06
 */
public class Test665 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        boolean flag = false;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                if (flag) return false;
                flag = true;
                if (i == 1 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i - 2];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,3, 2, 3};
        boolean res = new Test665().checkPossibility(nums);
        System.out.println(res);
    }
}
