import java.util.Scanner;

/**
 * @author Qin Kai
 * @date 2020-02-28
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] ss = sc.nextLine().split(" ");
            System.out.println(Integer.parseInt(ss[0]) + Integer.parseInt(ss[1]));
        }
    }
}
