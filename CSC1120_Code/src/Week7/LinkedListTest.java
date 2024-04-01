package Week7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        assertEquals(2, list.size());
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
        System.out.println(list.toString());

    }

    @Test
    void get() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
    }

    @Test
    void indexOf() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        assertEquals(0, list.indexOf(5));
        assertEquals(1, list.indexOf(10));
    }

    @Test
    void remove() {
    }

    @Test
    void set() {
    }

    @Test
    void size() {
    }

    @Test
    void toArray() {
    }
}