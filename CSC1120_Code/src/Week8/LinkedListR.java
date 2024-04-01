package Week8;

import java.util.NoSuchElementException;

/**
 * This class represents a singly linked list.
 * It uses a private static inner class Node that represents a node in the singly linked list.
 * Each Node in the LinkedList contains a data of generic type and a reference to the next node.
 * The LinkedList has a total of size number of nodes.
 *
 * @param <E> the type of elements in this list
 */
public class LinkedListR<E> {
    /**
     * Head of the linked list. It is initially null.
     */
    private Node<E> head = null;
    /**
     * Size of the linked list. It is initially zero.
     */
    private int size = 0;


    /**
     * A generic node in the singly linked list that holds a data and a reference to the next node.
     *
     * @param <E> the type of elements in the linked list
     */
    private static class Node<E> {
        /**
         * Data of generic type stored in the Node.
         */
        private E data;
        /**
         * Reference to the next Node. It is initially null.
         */
        private Node<E> next;

        /**
         * Constructor to create a new node with a null next field.
         * The next field is set to null because the new node is being added at the beginning of the linked list.
         * @param dataItem The data stored.
         */
        private Node(E dataItem) {
            this.data = dataItem;
            this.next = null;
        }

        /**
         * Constructor to create a new node that references another node
         * The next field of the new node is set to reference the node referenced by the nodeRef parameter.
         * @param dataItem The data stored
         * @param nodeRef  The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            this.data = dataItem;
            // In the constructor, the next field of the new node is set to reference the node referenced by the nodeRef parameter.
            // This effectively inserts the new node into the linked list after the node referenced by nodeRef.
            this.next = nodeRef;
        }
    }

    /**
     * Method to add a new node at the beginning of the linked list.
     * The new node is added at the beginning of the linked list by creating a new node with the new data and a reference to the current head node.
     * The head reference is then updated to reference the new node.
     * @param item The data item to be added in the new node.
     */
    void addFirst(E item) {
        head = new Node<E>(item, head); // initiallly head is null so the new node is added at the beginning of the linked list
        size++;
    }

    /**
     * Method to add a new node after a given node.
     * The new node is added after a given node by creating a new node with the new data and a reference to the node referenced by the node parameter.
     * @param node The node after which the new node is added.
     * @param item The data item to be added in the new node.
     */
    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }
    /**
     * Method to replace the data at the specified index with a new data
     * @param index The index of the data to be replaced
     * @param anEntry The new data to replace the old data
     */

    public void add(int index, E anEntry) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index == 0) {
            addFirst(anEntry);
        } else {
            Node<E> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            addAfter(node, anEntry);
        }
    }
    public boolean add(E e) { // O(n)
        Node<E> node = new Node<>(e);
        if(size == 0) {
            head = node;
        } else {
            Node<E> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        ++size;
        return true;
    }


    /**
     * Method to remove the first node and returns the data from the removed node.
     *
     * @return The data from the removed node, or null if there is no node to remove.
     */
    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
            return null;
        }
    }
    /**
     * Method to remove the node following a given node and returns the data from the removed node.
     *
     * @param node The preceding node of the node to be removed.
     * @return The data from the removed node, or null if there is no node to remove.
     */
    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }


    /**
     * Method to replace the data at the specified index with a new data
     * @param index The index of the data to be replaced
     * @return
     */

    //Remove method
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index == 0) {
            return removeFirst();
        } else {
            Node<E> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            return removeAfter(node);
        }
    }
    /**
     * Method to find the node at a specified index.
     * @param index The index of the node to be found
     * @return The node at the specified index
     */

    //Get method
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }
    // Set method
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        E oldValue = node.data;
        node.data = newValue;
        return oldValue;
    }




    //Contains method
    public boolean contains(E anEntry) {
        Node<E> node = head;
        while (node != null) {
            if (node.data.equals(anEntry)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
    //Size method
    public int size() {
        return size;
    }
    //isEmpty method
    public boolean isEmpty() {
        return size == 0;
    }
    //toString method
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> node = head;
        while (node != null) {
            sb.append(node.data);
            node = node.next;
            if (node != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}