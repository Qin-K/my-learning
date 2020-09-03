/**
 * @author Qin Kai
 * @date 2019-11-03
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
