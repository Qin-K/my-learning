/**
 * @author Qin Kai
 * @date 2020-02-21
 */
public class Test58_2左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0) {
            return  str;
        }
        if (n >= str.length()) {
            n %= str.length();
        }
        return str.substring(n) + str.substring(0, n);
    }
}
