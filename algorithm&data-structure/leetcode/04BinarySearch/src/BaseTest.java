/**
 * @author Qin Kai
 * @date 2019-12-08
 */
public class BaseTest {


    public int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变种，对于有重复元素的有序数组，返回目标值最左边的下标
     */
    public int binarySearch02(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target <= arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }

            if (l == r && target == arr[l]) {
                return l;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 4, 5};
//        int res = new BaseTest().binarySearch(arr, 2);
        int res = new BaseTest().binarySearch02(arr, 2);
        System.out.println(res);
    }
}
