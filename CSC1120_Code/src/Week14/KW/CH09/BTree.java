/*<listing chapter="9" section="5">*/
package Week14.KW.CH09;

import Week14.KW.CH06.SearchTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * An implementation of the B-tree. A B-tree is a
 * search tree in which each node contains n data items where
 * n is between N/2 and N. (For the root, n may be between 1
 * and N. Other than leaves there are n+1 children.  The tree 
 * is always balanced in that all leaves are on the same level, 
 * i.e., the length of the path  from the root to a leaf is 
 * constant.
 * @param <E> The element type
 * @author Koffman and Wolfgang
 */
public class BTree<E extends Comparable<E>>  implements SearchTree<E> {

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Nested class

    /** A Node represents a node in a B-tree tree.
     * @param <E> The element type
     */
    protected static class Node<E> {
        // Data Fields

        /** The number of data items in this node */
        public int size = 0;
        /** The information */
        public final E[] data;
        /** The links to the children. child[i] refers to
         *  the subtree of children &lt; data[i] for i &lt; size
         *  and to the subtree of children &gt; data[size-1]
         *  for i == size  */
        public final Node<E>[] child;

        /**
         * Create an empty node of size nn
         * @param order - The size of a node
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        public Node(int order) {
            data = (E[]) new Comparable[order - 1];
            child = (Node<E>[]) new Node[order];
            size = 0;
        }

        /**
         * Return a String representation of this node
         * @return a String representation of this node
         */
        @Override
        public String toString() {
            var sj = new StringJoiner(", ");
            for (E item : data) {
                sj.add(item.toString());
            }
            return sj.toString();
        }
    }
    // Data fields
    
    private int size;
    
    public int size() {
        return size;
    }
    /** The reference to the root. */
    protected Node<E> root = null;
    /** The maximum number of children of a node */
    private int order;
    /** The parent of a split node returned from insert */
    private E newParent;
    /** The right half of a split node returned from insert */
    private Node<E> newChild;

    /**
     * Construct a B-tree with a specified order
     * @param order - the size of a node
     * @throws IllegalArgumentException if order &lt; 3
     */
    public BTree(int order) {
        if (order < 3) {
            throw new IllegalArgumentException("order < 3");
        }
        this.order = order;
        root = null;
    }

    /**
     * Determine if an item is in the tree
     * @param target Item being sought in tree
     * @return true If the item is in the tree, false otherwise
     */
    @Override
    public boolean contains(E target) {
        return find(target) != null;
    }

    /**
     * Find an object in the tree
     * @param item The object sought, must be Comparable
     * @return The object in the tree, or null
     *         if the object is not in the tree
     */
    @Override
    public E find(E item) {
        return find(root, item);
    }

    /**
     * Recursive find method. Find the object
     * in the node or one of its children
     * @param node The node to search
     * @param item The object sought, must be Comparable
     * @return The object in the tree, or null
     *         if the object is not in the tree
     */
    private E find(Node<E> node, E item) {
        if (node == null) {
            return null;
        }
        int index = 0;
        while (index < node.size && item.compareTo(node.data[index]) > 0) {
            ++index;
        }
        if (index == node.size || item.compareTo(node.data[index]) < 0) {
            return find(node.child[index], item);
        } else {
            return node.data[index];
        }
    }

    /**
     * Insert an Object into the tree.  Inserted item
     * must implement the Comparable interface
     * @param item The object to be inserted
     * @return true if the item was inserted
     */
    @Override
    public boolean add(E item) {
        if (order == 0) {
            throw new IllegalStateException("Must set order first");
        }
        if (root == null) {
            root = new Node<>(order);
            root.data[0] = item;
            root.size = 1;
            return true;
        }
        newChild = null;
        boolean result = insert(root, item);
        if (newChild != null) {
            var newRoot = new Node<E>(order);
            newRoot.child[0] = root;
            newRoot.child[1] = newChild;
            newRoot.data[0] = newParent;
            newRoot.size = 1;
            root = newRoot;
        }
        if (result) {
            size++;
        }
        return result;
    }

    /*<listing chapter="9" number="5">*/
    /**
     * Recursive insert an Object into the Tree. Inserted
     * item must implement the Comparable interface
     * @param root - The local root
     * @param item - The item to be inserted
     * @return true if the item was inserted, false
     *         if the item is already in the tree
     */
    private boolean insert(Node<E> root, E item) {
        int index = binarySearch(item, root.data, 0, root.size);
        if (index != root.size && item.compareTo(root.data[index]) == 0) {
            return false;
        }
        if (root.child[index] == null) {
            if (root.size < order - 1) {
                insertIntoNode(root, index, item, null);
                newChild = null;
            } else {
                splitNode(root, index, item, null);
            }
            return true;
        } else {
            boolean result = insert(root.child[index], item);
            if (newChild != null) {
                if (root.size < order - 1) {
                    insertIntoNode(root, index, newParent, newChild);
                    newChild = null;
                } else {
                    splitNode(root, index, newParent, newChild);
                }
            }
            return result;
        }
    }
    /*</listing>*/

    /**
     * Method to insert a new value into a node
     * preode.data[index-1] &amp;lt; item %lt; node.data[index];
     * postnode.data[index] == item and old values are moved
     *       right one
     * @param node The node to insert the value into
     * @param index The index where the inserted item is to be placed
     * @param item The value to be inserted
     * @param child The right child if the value
     */
    private void insertIntoNode(Node<E> node, int index, E item, Node<E> child) {
        for (int i = node.size; i > index; i--) {
            node.data[i] = node.data[i - 1];
            node.child[i + 1] = node.child[i];
        }
        node.data[index] = item;
        node.child[index + 1] = child;
        node.size++;
    }

    /*<listing chapter="9" number="6">*/
    /**
     * Method to split a node
     * @param node - The node to be split
     * @param index - The index where the new item is to be inserted
     * @param item - The item to be inserted
     * @param child - Reference to the subtree containing items greater than item
     */
    private void splitNode(Node<E> node, int index, E item, Node<E> child) {
        // Create new child
        newChild = new Node<>(order);
        // Determine number of items to move
        int numToMove = (order - 1) - ((order - 1) / 2);
        // If insertion point is to the right half, move one less item
        if (index > (order - 1) / 2) {
            numToMove--;
        }
        // Move items and their children
        System.arraycopy(node.data, order - numToMove - 1,
                newChild.data, 0, numToMove);
        System.arraycopy(node.child, order - numToMove,
                newChild.child, 1, numToMove);
        node.size = order - numToMove - 1;
        newChild.size = numToMove;
        // Insert new item
        if (index == ((order - 1) / 2)) { // Insert into middle
            newParent = item;
            newChild.child[0] = child;
        } else {
            if (index < ((order - 1) / 2)) { // Insert into the left
                insertIntoNode(node, index, item, child);
            } else {
                insertIntoNode(newChild, index - ((order - 1) / 2) - 1,
                        item, child);
            }
            // The rightmost item of the node is the new parent
            newParent = node.data[node.size - 1];
            // Its child is the left child of the split-off node
            newChild.child[0] = node.child[node.size];
            node.size--;
        }
        // Remove contents and references to moved items
        for (int i = node.size; i < node.data.length; i++) {
            node.data[i] = null;
            node.child[i + 1] = null;
        }
    }
    /*</listing>*/

    /*<exercise chapter="9" section="5" type="programming" number="1">*/
    /**
     * Perform a binary search of the array data for target.
     * @param target The item being sought
     * @param data The sorted array the may contain the data
     * @param first The first index to be searched
     * @param last One past the last index to be searched
     * @return The smallest index such that target &gt;= data[index]
     */
    private int binarySearch(E target, E[] data, int first, int last) {
        if (first == last) {
            return first;
        }
        if (last - first == 1) {
            if (target.compareTo(data[first]) <= 0) {
                return first;
            } else {
                return last;
            }
        }
        int middle = first + (last - first) / 2;
        int compResult = target.compareTo(data[middle]);
        if (compResult == 0) {
            return middle;
        }
        if (compResult < 0) {
            return binarySearch(target, data, first, middle);
        } else {
            return binarySearch(target, data, middle + 1, last);
        }
    }
    /*</exercise>*/

    /**
     * Remove an object from the tree. This is an
     * unsupported operation.
     * @param o - The object to be removed
     * @return true if the object is removed
     * @throws UnsupportedOperationException if called.
     */
    @Override
    public boolean remove(E o) {
        throw new UnsupportedOperationException("Remove from B-trees "
                + "not implemented");
    }

    /**
     * Remove an object from the tree. This is an
     * unsupported operation.
     * @param o - The object to be removed
     * @return The object removed or null if not in the
     * tree
     * @throws UnsupportedOperationException if called.
     */
    @Override
    public E delete(E o) {
        throw new UnsupportedOperationException("Delete from B-trees not"
                + " implemented");
    }

    /**
     * Return a pre-order traversal as the string
     * representation of the tree
     * @return a string representation of the tree
     */
    @Override
    public String toString() {
        var sb = new StringBuilder();
        preOrderTraverse(root, 0, sb);
        return sb.toString();
    }

    /**
     * Perform a pre-order traversal
     * @param node - The local root
     * @param d - The depth
     * @param sb - The string buffer to put the output
     */
    private void preOrderTraverse(Node<E> node, int d, StringBuilder sb) {
        for (int i = 0; i != d; ++i) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null");
        } else {
            var sj = new StringJoiner(", ");
            for (int i = 0; i != node.size; ++i) {
                sj.add(node.data[i].toString());
            }
            sb.append(sj.toString());
            sb.append("\n");
            for (int i = 0; i != node.size; ++i) {
                preOrderTraverse(node.child[i], d + 1, sb);
                sb.append("\n");
            }
            preOrderTraverse(node.child[node.size], d + 1, sb);
            sb.append("\n\n");
        }
    }

    /**
     * Return a list containing the contents of the search tree in ascending order.
     * @return a list containing the contents of the search tree in ascending order.
     */
    @Override
    public List<E> toList() {
        List<E> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list;
    }

    /**
     * Perform an in-order traversal, appending the output to a List
     * @param node - The local root
     * @param d - The depth
     * @param list - The string buffer to put the output
     */
    private void inOrderTraverse(Node<E> node, List<E> list) {
        if (node != null) {            
            for (int i = 0; i != node.size; ++i) {
                inOrderTraverse(node.child[i], list);
                list.add(node.data[i]);
            }
            inOrderTraverse(node.child[node.size], list);
        }
    }
    
    /**
     * Remove all items from this BTree
     */
    @Override
    public void clear() {
        root = null;
    }
    
}
/*</listing>*/
