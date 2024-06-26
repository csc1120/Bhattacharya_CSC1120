/*<listing chapter="6" section="4">*/
package Week14.KW.CH06;

import java.util.List;
import java.util.ArrayList;

/**
 * A class to represent a binary search tree.
 *
 * @param <E> The element type
 * @author Koffman and Wolfgang
 */
public class BinarySearchTree<E extends Comparable<E>>
        extends BinaryTree<E>
        implements SearchTree<E> {
    
    /**
     * Package Private constructor for testing.
     */
    BinarySearchTree (E theData, BinarySearchTree<E> left, BinarySearchTree<E> right) {
        super(theData, left, right);
        size = 0;
    }
    
    /**
     * Public no-argument constructor.
     */
    public BinarySearchTree() {
        super();
    }
    
    /**
     * The number of items in the tree;
     */
    protected int size;
    
    /**
     * Return the number of items in the tree.
     * @return The size of the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return value from the public add method.
     */
    protected boolean addReturn;
    /**
     * Return value from the public delete method.
     */
    protected E deleteReturn;

    //Methods
    /*<listing chapter="6" number="4">*/
    /**
     * Starter method find.
     *
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    @Override
    public E find(E target) {
        return find(root, target);
    }

    /**
     * Recursive find method.
     *
     * @param localRoot The local subtree�s root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {
        if (localRoot == null) {
            return null;
        }

        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0) {
            return localRoot.data;
        } else if (compResult < 0) {
            return find(localRoot.left, target);
        } else {
            return find(localRoot.right, target);
        }
    }
    /*</listing>*/

    /*<listing chapter="6" number="5">*/
    /**
     * Starter method add.
     *
     * @param item The object being inserted
     * @return true if the object is inserted, false if the object already
     * exists in the tree
     */
    @Override
    public boolean add(E item) {
        root = add(root, item);
        if (addReturn) {
            size++;
        }
        return addReturn;
    }

    /**
     * Recursive add method.
     *
     * postThe data field addReturn is set true if the item is added to the
     * tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the inserted item
     */
    protected Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree � insert it.
            addReturn = true;
            return new Node<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    /*</listing>*/

    /*<listing chapter="6" number="6">*/
    /**
     * Starter method delete.
     *
     * postThe object is not in the tree.
     * @param target The object to be deleted
     * @return The object deleted from the tree or null if the object was not in
     * the tree
     */
    @Override
    public E delete(E target) {
        root = delete(root, target);
        if (deleteReturn != null) {
            size--;
        }
        return deleteReturn;
    }

    /**
     * Recursive delete method.
     *
     * postThe item is not in the tree; deleteReturn is equal to the deleted
     * item as it was stored in the tree or null if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain the item
     */
    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    /*</listing>*/

    /*<exercise chapter="6" section="5" type="programming" number="1">*/
    /**
     * Removes target from tree.
     *
     * @param target Item to be removed
     * @return true if the object was in the tree, false otherwise
     * posttarget is not in the tree
     */
    @Override
    public boolean remove(E target) {
        return delete(target) != null;
    }

    /**
     * Determine if an item is in the tree
     *
     * @param target Item being sought in tree
     * @return true If the item is in the tree, false otherwise
     * @throws ClassCastException if target is not Comparable
     */
    @Override
    public boolean contains(E target) {
        return find(target) != null;
    }
    /*</exercise>*/

    /*<listing chapter="6" number="7">*/
    /**
     * Find the node that is the in-order predecessor and replace it with its
     * left child (if any).
     *
     * postThe in-order predecessor is removed from the tree.
     * @param parent The parent of possible in-order predecessor (ip)
     * @return The data in the ip
     */
    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }
    /*</listing>*/

    /*<exercise chapter="6" section="5" type="programming" number="2">*/
    /**
     * Starter method deletePrime. deletePrime is the same as delete except that
     * when a value is deleted that has two children the in-order successor
     * replaces it in the tree.
     *
     * postThe object is not in the tree.
     * @param target The object to be deleted
     * @return The object deleted from the tree or null if the object was not in
     * the tree
     * @throws ClassCastException if target does not implement Comparable
     */
    public E deletePrime(E target) {
        root = deletePrime(root, target);
        return deleteReturn;
    }

    /**
     * Recursive deletePrime method.
     *
     * postThe item is not in the tree; deleteReturn is equal to the deleted
     * item as it was stored in the tree or null if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain the item
     */
    private Node<E> deletePrime(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = deletePrime(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = deletePrime(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder successor.
                if (localRoot.right.left == null) {
                    // The right child has no left child.
                    // Replace the data with the data in the
                    // right child.
                    localRoot.data = localRoot.right.data;
                    // Replace the right child with its right child.
                    localRoot.right = localRoot.right.right;
                    return localRoot;
                } else {
                    // Search for the inorder successor (is) and
                    // replace deleted node's data with is.
                    localRoot.data = findSmallestChild(localRoot.right);
                    return localRoot;
                }
            }
        }
    }

    /**
     * Find the node that is the in-order successor and replace it with its
     * right child (if any).
     *
     * postThe in-order successor is removed from the tree.
     * @param parent The parent of possible in-order successor (is)
     * @return The data in the is
     */
    private E findSmallestChild(Node<E> parent) {
        // If the left child has no left child, it is
        // the inorder sucessor.
        if (parent.left.left == null) {
            E returnValue = parent.left.data;
            parent.left = parent.left.right;
            return returnValue;
        } else {
            return findSmallestChild(parent.left);
        }
    }
    /*</exercise>*/

    /*<exercise chapter="6" section="5" type="programming" number="3">*/
    /**
     * Return the contents of the BinarySearchTree as a List of items in
     * ascending order. (Note the exercise suggests returning a string of item
     * separated by newline characters, but a List is more general and useful
     * for the testing performed by the exercise. Also, the toString method of
     * the BinaryTree class would be hidden and it is useful to verify some of
     * the tests.
     *
     * @return A list containing the contents of the binary search tree
     */
    @Override
    public List<E> toList() {
        final List<E> result = new ArrayList<>();
        inOrderTraverse((e, d) -> {if (e != null) result.add(e);});
        return result;
    }

    /*</exercise>*/

    /**
     * Empty this BinarySearchTree
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
}
/*</listing>*/
