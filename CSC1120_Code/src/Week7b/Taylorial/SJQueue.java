package Week7b.Taylorial;

import Week7.LinkedList;
import Week7b.SJLinkedList;
// no such element exception
import java.util.NoSuchElementException;
public class SJQueue<E> {

    private final LinkedList<E> data = new LinkedList<>();
// add
    public boolean add(E e){
        return data.add(e);
    }


    //offer
    public boolean offer(E e){
        return data.add(e);
    }

    //element
    public E element() throws NoSuchElementException{
        if (data.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        return data.get(0);
    }
    //remove
    public E remove() throws  NoSuchElementException{
        if (data.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        return data.remove(0);
    }

    //peek
    public E peek(){
        if (data.isEmpty()){
            return null;
        }
        return data.get(0);
    }




    //poll

    public E poll(){
        if (data.isEmpty()){
            return null;
        }
        return data.remove(0);
    }
}
