/**
 * @author Qin Kai
 * @date 2020-02-09
 */
public class Test51_数组中的逆序对 {
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        help = new int[array.length];
        return mergeSort(array, 0, array.length - 1);
    }

    public int mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        return (mergeSort(array, l, mid) % 1000000007
                + mergeSort(array, mid + 1, r) % 1000000007
                + merge(array, l, mid, r) % 1000000007) % 1000000007;
    }
    int[] help;
    public int merge(int[] array, int l, int mid, int r) {
        System.arraycopy(array, l, help, l, r - l + 1);
        int p1 = l;
        int p2 = mid + 1;
        int cur = l;
        long cnt = 0;
        while (p1 <= mid && p2 <= r) {
            if (help[p1] <= help[p2]) {
                array[cur++] = help[p1++];
            } else {
                cnt += mid - p1 + 1;
                array[cur++] = help[p2++];
            }
        }

        while (p1 <= mid) {
            array[cur++] = help[p1++];
        }
        while (p2 <= r) {
            array[cur++] = help[p2++];
        }
        return (int)(cnt % 1000000007);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        int res = new Test51_数组中的逆序对().InversePairs(array);
        System.out.println(res);
    }
}
