/**
 * @author Qin Kai
 * @date 2019-12-01
 */
public class Test680 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left, right - 1)
                        || validPalindrome(s, left + 1,right);
            }

            left++;
            right--;
        }

        return true;
    }

    public boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean res = new Test680().validPalindrome("abccbaa");
        System.out.println(res);
    }
}
