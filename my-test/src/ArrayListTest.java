import java.util.*;

/**
 * @author Qin Kai
 * @date 2019-12-14
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(3, 1, 1));
        set.add(Arrays.asList(3, 1, 1));
        System.out.println(set.size());
        set.clear();
        Integer[] nums1 = {3, 1, 1};
        set.add(Arrays.asList(nums1));
        Integer[] nums2 = {3, 1, 2};
        List<Integer> list = new ArrayList<>();
        set.add(Arrays.asList(nums2));
        System.out.println(set.size());
        nums2[2] = 1;
        System.out.println(set.size());
    }
}
