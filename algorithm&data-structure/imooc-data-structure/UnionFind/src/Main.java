import java.util.Random;

/**
 * @author Qin Kai
 * @date 2019-11-03
 */
public class Main {

    public static double testUF(UF uf, int op) {
        long time1 = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < op; i++) {
            int p = random.nextInt(uf.getSize() / 2);
            int q = uf.getSize() / 2 + random.nextInt(uf.getSize() / 2);
            uf.unionElements(p,q);
            p = random.nextInt(uf.getSize() / 2);
            q = uf.getSize() / 2 + random.nextInt(uf.getSize() / 2);
            uf.isConnected(p, q);
        }

        long time2 = System.nanoTime();
        return (time2 - time1) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int op = 10000000;
        double r = testUF(new UnionFind1(size), op);
//        System.out.println("uf1: " + r + " s");
//        r = testUF(new UnionFind2(size), op);
//        System.out.println("uf2: " + r + " s");
        r = testUF(new UnionFind3(size), op);
        System.out.println("uf3: " + r + " s");
        r = testUF(new UnionFind4(size), op);
        System.out.println("uf4: " + r + " s");
        r = testUF(new UnionFind5(size), op);
        System.out.println("uf5: " + r + " s");
    }
}
