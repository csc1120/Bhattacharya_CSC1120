package Week7;



import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableLinkedList<E> extends LinkedList<E> {
    private final class LLIterator implements Iterator<E> {
        private LinkedList.Node<E> next;

        private LLIterator() {
            next = head;
        }

        public boolean hasNext() {
            return next != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("You have already exhausted the iterator");
            }
            E returnValue = next.value;
            next = next.next;
            return returnValue;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LLIterator();
    }
}
