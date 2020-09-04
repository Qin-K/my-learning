/**
 * @author Qin Kai
 * @date 2019-12-08
 */
public class Test153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) {
            return nums[l];
        }

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return nums[r];

    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 0, 1, 2};
        int res = new Test153().findMin(nums);
        System.out.println(res);
    }
}
