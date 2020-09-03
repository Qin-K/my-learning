/**
 * @author Qin Kai
 * @date 2019-12-09
 */
public class Test34 {

    // 使用两次二分，第一次查找第一位置，第二次查最后一个位置
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{-1, -1};
        }
        int left = findLeft(nums, target);
		int right = findRight(nums, target);
		return new int[]{left, right};
    }
	
	public int findLeft (int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (k < array[mid]) {
                r = mid - 1;
            } else if (k > array[mid]) {
                l = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] != k) {
                    return mid;
                }
                r = mid - 1;
            }
        }
        return -1;
    }
    public int findRight (int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (k < array[mid]) {
                r = mid - 1;
            } else if (k > array[mid]) {
                l = mid + 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] != k) {
                    return mid;
                }
                l = mid + 1;
            }
        }
        return -1;
    }

    // 使用两次查找第一个位置，查找target的最后一个位置 等价于 查找target + 1的位置 - 1
    // 但是自认为比较扣边界。。难搞
    public int[] searchRange02(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{-1, -1};
        }
        int left = searchFirst(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = searchFirst(nums, target + 1) - 1;
        return new int[]{left, Math.max(left, right)};
    }

    public int searchFirst(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid;
            } else if (target > nums[mid]){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        int[] nums = {5};
        int[] res = new Test34().searchRange02(nums, 5);
        System.out.println(res[0] + "," + res[1]);
    }
}
