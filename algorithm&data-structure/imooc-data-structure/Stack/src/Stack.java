/**
 * @author Qin Kai
 * @date 2019-10-26
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
