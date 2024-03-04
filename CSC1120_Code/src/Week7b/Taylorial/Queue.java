package Week7b.Taylorial;

import java.util.LinkedList;

public class Queue<E> implements PureQueue<E> {
    private LinkedList<E> theWorker;

    public Queue() {
        theWorker = new LinkedList<>();
    }

    @Override
    public void offer(E item) {
        theWorker.add(item);
    }

    @Override
    public E poll() {
        return theWorker.remove(0);
    }

    @Override
    public E peek() {
        return theWorker.get(0);
    }

    @Override
    public int size() {
        return theWorker.size();
    }
}
