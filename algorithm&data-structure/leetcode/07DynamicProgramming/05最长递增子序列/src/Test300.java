import java.util.ArrayList;
import java.util.List;

/**
 * @author Qin Kai
 * @date 2019-12-20
 */
public class Test300 {
    /**
     * 使用dfs暴力
     */
    private int max;
    public int lengthOfLIS01(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return max;
    }

    public void dfs(int[] nums, int cur, List<Integer> tempList) {
        int size = tempList.size();
        if (size + nums.length - cur < max) {
            return;
        }
        if (cur == nums.length) {
            if (size > max) {
                max = size;
            }
            return;
        }
        if (tempList.size() == 0 || nums[cur] > tempList.get(size - 1)) {
            tempList.add(nums[cur]);
            dfs(nums, cur + 1, tempList);
            tempList.remove(size);
        }

        dfs(nums, cur + 1, tempList);
    }

    // dp
    public int lengthOfLIS02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int d : dp) {
            if (d > max) {
                max = d;
            }
        }

        return max;
    }

    // dp nlogn
    public int lengthOfLIS03(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int index = binarySearch(dp, len, nums[i]);
            dp[index] = nums[i];
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    public int binarySearch(int[] arr, int len, int num) {
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (num < arr[mid]) {
                r = mid - 1;
            } else if (num > arr[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return l;
    }



    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
//        int res = new Test300().lengthOfLIS01(nums);
//        int res = new Test300().lengthOfLIS02(nums);
        int res = new Test300().lengthOfLIS03(nums);
        System.out.println(res);
    }
}
