package Array;

public interface Stack<E> {
    int getSize();
    E pop();
    E peel();
    void push(E e);
    boolean isEmpty();
}
