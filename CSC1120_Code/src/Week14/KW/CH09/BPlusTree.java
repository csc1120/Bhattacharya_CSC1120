package Week14.KW.CH09;

import Week14.KW.CH06.SearchTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * An implementation of the B+Tree.A B+Tree is a search tree in which each node
 * contains n data items where n is between N/2 and N. (For the root, n may be
 * between 1 and N. Other than leaves there are n+1 children. The tree is always
 * balanced in that all leaves are on the same level, i.e., the length of the
 * path from the root to a leaf is constant. The B+Tree is similar to the B-Tree
 * except that the leaf nodes contain references (pointers) to data associated
 * with the keys, while the internal nodes contain references (pointers) to the
 * child nodes. For illustration purposes, the leaf nodes will not contain any
 * references to data. Leaf nodes also contain a link reference to their
 * sibling.
 *
 * @author Koffman and Wolfgang
 * @param <E> The element type.
 */
public class BPlusTree<E extends Comparable<E>> implements SearchTree<E> {
    // Nested class

    /**
     * A Node represents a node in a B-tree tree.
     */
    private abstract class Node {
        // Data Fields

        /**
         * The number of data items in this node
         */
        protected int size = 0;
        /**
         * The information
         */
        protected E[] keys;

        /**
         * Create an empty node of size nn
         *
         * @param cap - The size of a node
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        public Node(int cap) {
            keys = (E[]) new Comparable[cap - 1];
            size = 0;
        }
        
        public abstract int getDepth();

        /**
         * Return a String representation of this node
         *
         * @return a String representation of this node
         */
        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(", ");
            for (int i = 0; i < size; i++) {
                sj.add(keys[i].toString());
            }
            return sj.toString();
        }

        public abstract E find(E item);

        public abstract boolean insert(E item);
        
        public abstract void insertIntoNode(int index, E item, Node theChild);

        public abstract void splitNode(int index, E item, Node itemsChild);

        @SuppressWarnings("unchecked")
	@Override
        public Node clone() {
            try {
                return (Node) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

    }

    private class InternalNode extends Node {

        /**
         * The links to the children. child[i] refers to the subtree of children
         * &amp;lt; data[i] for i &amp;lt; size and to the subtree of children &amp;gt;&gt;
         * data[size-1] for i == size
         */
        private final Node[] child;

        /**
         * Create an empty node of size nn
         *
         * @param cap - The size of a node
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
		public InternalNode(int cap) {
            super(cap);
            child = new BPlusTree.Node[cap];
        }

        /**
         * Recursive find method. Find the object in the node or one of its
         * children
         *
         * @param node The node to search
         * @param item The object sought, must be Comparable
         * @return The object in the tree, or null if the object is not in the
         * tree
         */
        @Override
        public E find(E item) {
            int index = binarySearch(item, keys, 0, size);
            return child[index].find(item);
        }

        /**
         * Recursive insert an Object into the Tree. Inserted item must
         * implement the Comparable interface
         *
         * @param item - The item to be inserted
         * @return true if the item was inserted, false if the item is already
         * in the tree
         */
        @Override
        public boolean insert(E item) {
            int index = binarySearch(item, keys, 0, size);
            if (index != size && item.compareTo(keys[index]) == 0) {
                return false;
            }
            boolean result = child[index].insert(item);
            if (newChild != null) {
                if (size < cap - 1) {
                    insertIntoNode(index, newParent, newChild);
                    newChild = null;
                } else {
                    splitNode(index, newParent, newChild);
                }
            }
            return result;
        }

        /**
         * Method to insert a new value into a node
         *
         * pre: node.data[index-1] &amp;lt; item &amp;lt; node.data[index];
         * post: node.data[index] == item and old values are moved right one
         * @param node The node to insert the value into
         * @param index The index where the inserted item is to be placed
         * @param item The value to be inserted
         * @param theChild The right child of the value
         */
        @Override
        public void insertIntoNode(int index, E item, Node theChild) {
            for (int i = size; i > index; i--) {
                keys[i] = keys[i - 1];
                child[i + 1] = child[i];
            }
            keys[index] = item;
            child[index + 1] = theChild;
            size++;
        }

        /**
         * Method to split a node
         *
         * @param index - The index where the new item is to be inserted
         * @param item - The item to be inserted
         * @param itemsChild - Reference to the subtree containing items greater than
         * item
         */
        @SuppressWarnings("unchecked")
	@Override
        public void splitNode(int index, E item, Node itemsChild) {
            // Create new child
            newChild = new InternalNode(cap);
            // Determine number of items to move
            int numToMove = (cap - 1) - ((cap - 1) / 2);
            // If insertion point is to the right half, move one less item
            if (index > (cap - 1) / 2) {
                numToMove--;
            }
            // Move items and their children
            System.arraycopy(keys, cap - numToMove - 1, newChild.keys, 0, numToMove);
            System.arraycopy(child, cap - numToMove, ((InternalNode)newChild).child, 1, numToMove);
            size = cap - numToMove - 1;
            newChild.size = numToMove;
            // Insert new item
            if (index == ((cap - 1) / 2)) { // Insert into middle
                newParent = item;
                ((InternalNode)newChild).child[0] = itemsChild;
            } else {
                if (index < ((cap - 1) / 2)) { // Insert into the left
                    insertIntoNode(index, item, itemsChild);
                } else {
                    newChild.insertIntoNode(index - ((cap - 1) / 2) - 1, item, itemsChild);
                }
                // The rightmost item of the node is the new parent
                newParent = keys[size - 1];
                // Its child is the left child of the split-off node
                ((InternalNode)newChild).child[0] = child[size];
                size--;
            }
            // Remove contents and references to moved items
            for (int i = size; i < keys.length; i++) {
                keys[i] = null;
                child[i + 1] = null;
            }
        }

        /**
         * Make a clone of this node.
         */
        @Override
        public InternalNode clone() {
            @SuppressWarnings("unchecked")
            InternalNode theClone = (InternalNode) super.clone();
            for (int i = 0; i < child.length; i++) {
                if (theClone.child[i] != null) {
                    theClone.child[i] = child[i].clone();
                }
            }
            return theClone;
        }
        
        @Override
        public int getDepth() {
            return 1 + child[0].getDepth();
        }
    }

    private class Leaf extends Node {
        
        private Leaf rightSibling;

        public Leaf(int cap) {
            super(cap);
            rightSibling = null;
        }

        /**
         * Recursive find method. Find the object in the node or one of its
         * children
         *
         * @param node The node to search
         * @param item The object sought, must be Comparable
         * @return The object in the tree, or null if the object is not in the
         * tree
         */
        @Override
        public E find(E item) {
            int index = binarySearch(item, keys, 0, size);
            if (index == size || item.compareTo(keys[index]) < 0) {
                return null;
            } else {
                return keys[index];
            }
        }

        /**
         * Recursive insert an Object into the Tree. Inserted item must
         * implement the Comparable interface
         *
         * @param root - The local root
         * @param item - The item to be inserted
         * @return true if the item was inserted, false if the item is already
         * in the tree
         */
        @Override
        public boolean insert(E item) {
            int index = binarySearch(item, keys, 0, size);
            if (index != size && item.compareTo(keys[index]) == 0) {
                return false;
            }
            if (size < cap - 1) {
                insertIntoNode(index, item, null);
                newChild = null;
            } else {
                splitNode(index, item, null);
            }
            return true;
        }

        /**
         * Method to insert a new value into a node
         *
         * pre key[index-1] &amp;lt; item &amp;lt; key[index];
         * post key[index] == item and old values are moved right one
         * @param index The index where the inserted item is to be placed
         * @param item The value to be inserted
         * @param child The right child of the value Not Used.
         */
        @Override
        public void insertIntoNode(int index, E item, Node itemChild) {
            for (int i = size; i > index; i--) {
                keys[i] = keys[i - 1];
            }
            keys[index] = item;
            size++;
        }

        /**
         * Method to split a node
         *
         * @param node - The node to be split
         * @param index - The index where the new item is to be inserted
         * @param item - The item to be inserted
         * @param child - Reference to the subtree containing items greater than
         * item NOT USED.
         */
        @Override
        public void splitNode(int index, E item, Node itemChild) {
            // Create new child
            rightSibling = new Leaf(cap);
            newChild = rightSibling;
            // Determine number of items to move
            int numToMove = (cap - 1) - ((cap - 1) / 2);
            // Move items and their children
            System.arraycopy(keys, cap - numToMove - 1, newChild.keys, 0, numToMove);
            size = cap - numToMove;
            newChild.size = numToMove;
            // Insert new item
            if (index < ((cap - 1) / 2)) { // Insert into the left
                insertIntoNode(index, item, null);
            } else {
                newChild.insertIntoNode(index - ((cap - 1) / 2), item, null);
            }
            // The left most item of the new child node is the new parent
            newParent = newChild.keys[0];
            size--;
            // Remove contents and references to moved items
            for (int i = size; i < keys.length; i++) {
                keys[i] = null;
            }
        }
        
        @Override
        public int getDepth() {
            return 1;
        }

    }
    
    private int size;
    
    @Override
    public int size() {
        return size;
    }

    /**
     * The reference to the root.
     */
    private Node root = null;
    /**
     * The maximum number of children of a node
     */
    private int cap;
    /**
     * The parent of a split node returned from insert
     */
    private E newParent;
    /**
     * The right half of a split node returned from insert
     */
    private Node newChild;

    /**
     * Construct a B-tree with node size nn
     *
     * @param cap - the size of a node
     */
    public BPlusTree(int cap) {
        this.cap = cap;
        root = null;
    }

    // Methods
    /**
     * Set the capacity of this BTree.May only be called if cap is 0
     *
     * @param cap The capacity
     */
    public void setCap(int cap) {
        if (this.cap != 0) {
            throw new IllegalStateException("May only set cap once");
        }
        this.cap = cap;
    }

    /**
     * Determine if an item is in the tree
     *
     * @param target Item being sought in tree
     * @return true If the item is in the tree, false otherwise
     */
    @Override
    public boolean contains(E target) {
        return find(target) != null;
    }

    /**
     * Find an object in the tree
     *
     * @param item The object sought, must be Comparable
     * @return The object in the tree, or null if the object is not in the tree
     */
    @Override
    public E find(E item) {
        if (root == null) {
            return null;
        } else {
            return root.find(item);
        }
    }

    /**
     * Insert an Object into the tree. Inserted item must implement the
     * Comparable interface
     *
     * @param item The object to be inserted
     * @return true if the item was inserted
     */
    @Override
    public boolean add(E item) {
        if (cap == 0) {
            throw new IllegalStateException("Must set cap first");
        }
        if (root == null) {
            root = new Leaf(cap);
            root.keys[0] = item;
            root.size = 1;
            return true;
        }
        newChild = null;
        boolean result = root.insert(item);
        if (newChild != null) {
            InternalNode newRoot = new InternalNode(cap);
            newRoot.child[0] = root;
            newRoot.child[1] = newChild;
            newRoot.keys[0] = newParent;
            newRoot.size = 1;
            root = newRoot;
        }
        if (result) {
            size++;
        }
        return result;
    }


    /**
     * Perform a binary search of the array data for target.
     *
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
        int middle = (first + last) / 2;
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

    /**
     * Remove an object from the tree. This is an unsupported operation.
     *
     * @param o - The object to be removed
     * @return true if the object is removed
     * @throws UnsupportedOperationException if called.
     */
    @Override
    public boolean remove(E o) {
        throw new UnsupportedOperationException("Remove from 2-3 trees not implemented");
    }

    /**
     * Remove an object from the tree. This is an unsupported operation.
     *
     * @param o - The object to be removed
     * @return The object removed or null if not in the tree
     * @throws UnsupportedOperationException if called.
     */
    @Override
    public E delete(E o) {
        throw new UnsupportedOperationException("Delete from B-trees not implemented");
    }
    
    private class Itr implements Iterator<E> {
        
        private Leaf node;
        private int index;
        
        public Itr(Leaf node, int index) {
            this.node = node;
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > node.size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = node.keys[index];
            index++;
            if (index > node.size) {
                if (node.rightSibling != null) {
                    node = node.rightSibling;
                    index = 0;
                }
            }
            return returnValue;
        }
        
    }

    /**
     * Returns an iterator to the contents of the tree
     *
     * @return An iterator to the contents of the tree
     */
    @SuppressWarnings("unchecked")
    @Override
	public Iterator<E> iterator() {
        Node localRoot = root;
        while (localRoot instanceof BPlusTree.InternalNode) {
            localRoot = ((InternalNode)localRoot).child[0];
        }
        return new Itr((Leaf)localRoot, 0);
    }

    /**
     * Returns an iterator to the contents of the tree beginning at the
     * specified item.
     *
     * @param item The value to start iteration
     * @return An iterator to the tree
     */
    @SuppressWarnings("unchecked")
	public Iterator<E> iterator(E item) {
        Node localRoot = root;
        int index = 0;
        while (localRoot instanceof BPlusTree.InternalNode) {
            InternalNode node = (InternalNode)localRoot;
            index = binarySearch(item, node.keys, 0, node.size);
            localRoot = node.child[index];
        }
        return new Itr((Leaf)localRoot, index);
    }

    /**
     * Return a pre-order traversal as the string representation of the tree
     *
     * @return a string representation of the tree
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 0, sb);
        return sb.toString();
    }
    
    /**
     * Return a list containing the contents of the search tree in ascending order.
     * @return a list containing the contents of the search tree in ascending order.
     */
    @Override
    public List<E> toList() {
        List<E> result = new ArrayList<>();
        var itr = iterator();
        while (itr.hasNext()) {
            result.add(itr.next());
        }
        return result;
    }

    /**
     * Perform a pre-order traversal
     *
     * @param node - The local root
     * @param d - The depth
     * @param sb - The string buffer to put the output
     */
    private void preOrderTraverse(Node node, int d, StringBuilder sb) {
        for (int i = 0; i != d; ++i) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null");
        } else {
            for (int i = 0; i != node.size; ++i) {
                sb.append(node.keys[i]);
                if (i != node.size - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
            if (node instanceof BPlusTree.InternalNode) {
                @SuppressWarnings("unchecked")
				InternalNode internalNode = (InternalNode) node;
                for (int i = 0; i != node.size; ++i) {
                    preOrderTraverse(internalNode.child[i], d + 1, sb);
                    sb.append("\n");
                }
                preOrderTraverse(internalNode.child[node.size], d + 1, sb);
                sb.append("\n\n");
            }
        }
    }

    /**
     * Make a clone of this tree
     */
    @Override
    public BPlusTree<E> clone() {
        try {
            @SuppressWarnings("unchecked")
			BPlusTree<E> theClone = (BPlusTree<E>) super.clone();
            if (theClone.root != null) {
                theClone.root = root.clone();
            }
            return theClone;
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }

    @Override
    public void clear() {
        root = null;
    }
    
    public int getDepth() {
        return root.getDepth();
    }
    
          
    
}
