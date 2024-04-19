package Week14.KW.CH06;

import java.util.Iterator;
import java.util.List;

/**
 * Interface to define a search tree
 *
 * @param <E> The element type
 * @author Koffman and Wolfgang
 *
 */
public interface SearchTree<E extends Comparable<E>> {

    /**
     * Inserts item where it belongs in the tree.
     *
     * @param item The item to be inserted
     * @return true If the item is inserted, false if the item was already in
     * the tree.
     */
    boolean add(E item);

    /**
     * Determine if an item is in the tree
     *
     * @param target Item being sought in tree
     * @return true If the item is in the tree, false otherwise
     */
    boolean contains(E target);

    /**
     * Find an object in the tree
     *
     * @param target The item being sought
     * @return A reference to the object in the tree that compares equal as
     * determined by compareTo to the target. If not found null is returned.
     */
    E find(E target);

    /**
     * Removes target from tree.
     *
     * @param target Item to be removed
     * @return A reference to the object in the tree that compares equal as
     * determined by compareTo to the target. If not found null is returned.
     * posttarget is not in the tree
     */
    E delete(E target);

    /**
     * Removes target from tree.
     *
     * @param target Item to be removed
     * @return true if the object was in the tree, false otherwise
     * posttarget is not in the tree
     */
    boolean remove(E target);

    /**
     * Return a list containing the contents of the search tree in ascending
     * order.
     *
     * @return a list containing the contents of the search tree in ascending
     * order.
     */
    List<E> toList();

    /**
     * Empty this SearchTree
     */
    void clear();
    
    /**
     * Return the number of items in the tree;
     * @return The number if items in the tree;
     */
    int size();
    
    /**
     * Return an iterator to the contents of the tree.
     * @return An iterator that does an in-order traversal of the tree.
     */
    Iterator<E> iterator();
}
