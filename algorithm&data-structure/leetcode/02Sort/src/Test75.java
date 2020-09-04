import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2019-12-03
 */
public class Test75 {
    public void sortColors01(int[] nums) {
        int[] rec = new int[3];
        for (int i = 0; i < nums.length; i++) {
            rec[nums[i]]++;
        }

        int cur = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < rec[i]; j++) {
                nums[cur++] = i;
            }
        }
    }

    public void sortColors02(int[] nums) {
        int less = -1;
        int more = nums.length;
        int cur = 0;
        while (cur < more) {
            if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] < 1) {
                swap(nums, ++less, cur++);
            } else {
                swap(nums, --more, cur);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
//        new Test75().sortColors01(nums);
        new Test75().sortColors02(nums);
        System.out.println(Arrays.toString(nums));
    }
}
