/**
 * @author Qin Kai
 * @date 2019-12-02
 */
public class Test215 {
    public int findKthLargest(int[] nums, int k) {
        return selectK(nums, 0, nums.length - 1, nums.length + 1 - k);
    }

    public int selectK(int[] nums, int l, int r, int k) {
        int p = partiton(nums, l, r);
        int pK = p - l + 1;
        if (pK == k) {
            return nums[p];
        } else if (pK > k) {
            return selectK(nums, l, p - 1,k );
        } else {
            return selectK(nums, p + 1, r, k - pK);
        }
    }

    public int partiton(int[] nums, int l, int r) {
        int p = nums[l];
        int left = l + 1;
        int right = r;
        while (left <= right) {
            while (left <= right && nums[left] <= p) {
                left++;
            }

            while (left <= right && nums[right] > p) {
                right--;
            }

            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, l, right);
        return right;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
//        int res = new Test215().selectK(nums, 0, nums.length - 1, 3);
        int res = new Test215().findKthLargest(nums, 2);
        System.out.println(res);
    }
}
