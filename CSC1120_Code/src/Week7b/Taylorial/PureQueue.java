package Week7b.Taylorial;

public interface PureQueue<E> {
    void offer(E item); // offer is the same as add
    E poll(); // poll is the same as remove
    E peek(); // peek is the same as get
    int size();
}
