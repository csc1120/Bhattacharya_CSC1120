package Week7d;

public class Queue<E> implements PureQueue<E>{

    private LinkedList<E>theWorker;

    public  Queue(){
        theWorker= new LinkedList<>();
    }
    @Override
    // enqueue is same as add method
    public void enqueue(E item) {
        theWorker.add(item);
    }

    @Override
    public E dequeue() {
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

    public boolean isEmpty() {
        return theWorker.isEmpty();
    }



}
