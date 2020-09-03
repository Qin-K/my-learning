/**
 * @author Qin Kai
 * @date 2020-03-28
 */
public class Test64_求1_n和 {
    // 不使用for while 乘法 条件判断
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        int res = new Test64_求1_n和().Sum_Solution(100);
        System.out.println(res);
    }
}
