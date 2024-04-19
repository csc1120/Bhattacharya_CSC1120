package Week7d;

import Week7.LinkedList;

import java.util.EmptyStackException;

public class SBStack<E> {
    public final LinkedList<E> data = new LinkedList<>();

    //empty
    public boolean empty() {
        return data.isEmpty();
    }
    //peek
    public E peek() throws EmptyStackException{
//        return data.get(0);
        if(data.isEmpty()) {
            throw new EmptyStackException();
        }

        return data.get(0);

//        try { // dont use it consume times
//            return data.getFirst();
//        }
////        catch(IndexOutOfBoundsException e) {
////           throw new EmptyStackException();
    }
    public E pop() throws EmptyStackException {
        if(data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.remove(0);
    }

    // push adds to the front of the list
    public E push(E item) {
        data.addFirst(item);
        return item;
    }

    public int size() {
        return data.size();
    }
}

