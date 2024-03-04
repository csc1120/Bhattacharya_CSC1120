package Week8;

public interface PureQueue<E> {
    void offer(E item);
    E poll();
    E peek();
    int size();
}
