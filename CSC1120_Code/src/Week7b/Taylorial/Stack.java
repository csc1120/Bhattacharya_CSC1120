package Week7b.Taylorial;

import java.util.List;

public class Stack<E> implements PureStack<E> {
    private List<E> theWorker;


    public Stack(List<E> list) {
        theWorker = list;
        theWorker.clear();
    }

    @Override
    public void push(E item) {
       // theWorker.add(item); // used with array list
        theWorker.add(0, item); // used with linked list
    }

    @Override
    public E pop() {

//return theWorker.remove(theWorker.size()-1); // used with array list
       return theWorker.remove(0); // used with linked list
    }

    @Override
    public E peek() {
        return theWorker.get(0);
        //return theWorker.get(theWorker.size()-1); // used with array list
    }

    @Override
    public int size() {
        return theWorker.size();
    }
}
