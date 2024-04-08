package Week10;

import java.util.LinkedList;
import java.util.List;

// Load factor = size / capacity
public class HashTable<E> {
    private List<E>[] table;
    public static final int DEFAULT_CAPACITY = 10;
    public static final double LOAD_FACTOR_THRESHOLD = 0.5;
    private int size;

    public HashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean contains(Object target) {
        int index = Math.abs(target.hashCode()) % table.length;
        return table[index] != null && table[index].contains(target);
    }

    public boolean remove(Object target) {
        boolean removed = false;
        int index = Math.abs(target.hashCode()) % table.length;
        if (table[index] != null && table[index].remove(target)) {
            removed = true;
            size--;
        }
        return removed;
    }

    private void ensureCapacity() {
        if ((double)size / table.length > LOAD_FACTOR_THRESHOLD) {
            List<E>[] newTable = new List[table.length * 2];
            for (List<E> bucket : table) {
                if (bucket != null) {
                    for (E element : bucket) {
                        int index = Math.abs(element.hashCode()) % newTable.length;
                        if (newTable[index] == null) {
                            newTable[index] = new LinkedList<>();
                        }
                        newTable[index].add(element);
                    }
                }
            }
            table = newTable;
        }
    }

    public boolean add(E element) {
        boolean added = false;
        ensureCapacity();
        int index = Math.abs(element.hashCode()) % table.length;
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        if (!table[index].contains(element)) {
            added = true;
            size++;
            table[index].add(element);
        }
        return added;
    }

    // custom method to print the table
    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + " ");
            if (table[i] != null) {
                for (E element : table[i]) {
                    System.out.print(element + " ");
                }
            }
            System.out.println();
        }
    }
    // creat hash function
    public int hashFunction(E element) {
        return Math.abs(element.hashCode()) % table.length;
    }
}







