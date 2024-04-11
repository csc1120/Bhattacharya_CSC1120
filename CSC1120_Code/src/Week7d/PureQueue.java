package Week7d;

public interface PureQueue<E> {
    void enqueue(E item ); // offer is same as add
    E dequeue(); // same as remove method

    E peek(); // same as get method

    int size();
}
