import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Qin Kai
 * @date 2019-12-01
 */
public class Test345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (!set.contains(arr[left])) {
                left++;
            }

            if (!set.contains(arr[right])) {
                right--;
            }

            if (set.contains(arr[left]) && set.contains(arr[right])) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String res = new Test345().reverseVowels("leetcode");
        System.out.println(res);
    }
}
