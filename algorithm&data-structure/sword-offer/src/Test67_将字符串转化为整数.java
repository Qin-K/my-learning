/**
 * @author Qin Kai
 * @date 2020-03-28
 */
public class Test67_将字符串转化为整数 {
    public int StrToInt(String str) {
        char[] charArr = str.toCharArray();
        int num = 0;
        int sign =  1;
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (c == '-' || c == '+') {
                if (i != 0) {
                    return 0;
                }
                if (c == '-') {
                    sign = -1;
                }
                continue;
            }

            if (!(c >= '0' && c <= '9')) {
                return 0;
            }
            if (num == 0) {
                num = (c - '0') * sign;
            } else {
                long t = num * 10L + sign * (c - '0');
                if (t > Integer.MAX_VALUE || t < Integer.MIN_VALUE) {
                    return 0;
                }
                num = (int) t;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int res = new Test67_将字符串转化为整数().StrToInt("" + Integer.MIN_VALUE);
        System.out.println(res);
    }
}
