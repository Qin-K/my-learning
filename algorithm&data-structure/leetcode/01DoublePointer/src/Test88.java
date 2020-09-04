import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2019-12-01
 */
public class Test88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[cur--] = nums2[p2--];
            } else {
                nums1[cur--] = nums1[p1--];
            }
        }

        while (p2 >= 0) {
            nums1[cur--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Test88().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
