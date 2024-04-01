package Week8;

import java.util.function.Consumer;
// Consumer is a functional interface that takes a single input and returns no result
// Comparable is a functional interface that takes a single input and returns an int
// The int is negative if the input is less than the object being compared to
// The int is positive if the input is greater than the object being compared to
// The int is 0 if the input is equal to the object being compared to
public class BST2<E extends Comparable<? super E>> {
      private static final class Node<E> {
        Node<E> left;
        Node<E> right;
        E value;

        Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node(E value) {
            this(value, null, null);
        }
    }

    private Node<E> root;

    public BST2() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean add(E element) {
        boolean added = false;
        if (isEmpty()) {
            root = new Node<>(element);
            added = true;
        } else {
            added = add(root, element);
        }
        return added;
    }

    private boolean add(Node<E> subroot, E element) {
        boolean added = false;
        int compare = subroot.value.compareTo(element);
        if (compare < 0) {
            if (subroot.right == null) {
                subroot.right = new Node<>(element);
            } else {
                added = add(subroot.right, element);
            }
        } else if (compare > 0) {
            if (subroot.left == null) {
                subroot.left = new Node<>(element);
            } else {
                added = add(subroot.left, element);
            }
        }
        return added;
    }

    public boolean contains(E target) {
        return contains(root, target);
    }

    private boolean contains(Node<E> subroot, E target) {
        boolean found = false;
        int compare;
        if (subroot != null) {
            compare = subroot.value.compareTo(target);
            if (compare == 0) {
                found = true;
            } else if (compare < 0) {
                found = contains(subroot.right, target);
            } else {
                found = contains(subroot.left, target);
            }
        }
        return found;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> subroot) {
        int count = 0;
        if (subroot != null) {
            count = 1 + Math.max(height(subroot.left), height(subroot.right));
        }
        return count;
    }
// height without recurssion


    public int size() {
        return size(root);
    }

    private int size(Node<E> subroot) {
        int count = 0;
        if (subroot != null) {
            count = 1 + size(subroot.left) + size(subroot.right);
        }
        return count;
    }


    public void preOrder(Consumer<E> element) {
        preOrder(root, element);
    }

    private void preOrder(BST2.Node<E> subroot, Consumer<E> element) {
        if (subroot != null) {
            element.accept(subroot.value); // accept is a method that takes a single input and returns no result
            preOrder(subroot.left, element);
            preOrder(subroot.right, element);
        }
    }

    public void inOrder(Consumer<E> element) {
        inOrder(root, element);
    }

    private void inOrder(BST2.Node<E> subroot, Consumer<E> element) {
        if (subroot != null) {
            inOrder(subroot.left, element);
            element.accept(subroot.value);
            inOrder(subroot.right, element);
        }
    }

    public void postOrder(Consumer<E> element) {
        postOrder(root, element);
    }
    private void postOrder(BST2.Node<E> subroot, Consumer<E> element) {
        if (subroot != null) {
            postOrder(subroot.left, element);
            postOrder(subroot.right, element);
            element.accept(subroot.value);
        }
    }

    public void clear() {
        root = null;
    }
    // finding the minimum value in the tree
    public E findMin() {
        return findMin(root);
    }
    private E findMin(Node<E> subroot) {
        if (subroot.left == null) {
            return subroot.value;
        } else {
            return findMin(subroot.left);
        }
    }
    // finding the maximum value in the tree
    public E findMax() {
        return findMax(root);
    }
    private E findMax(Node<E> subroot) {
        if (subroot.right == null) {
            return subroot.value;
        } else {
            return findMax(subroot.right);
        }
    }
    // finding the successor of a node
    public E findSuccessor(E target) {
        return findSuccessor(root, target);
    }
    private E findSuccessor(Node<E> subroot, E target) {
        if (subroot != null) {
            int compare = subroot.value.compareTo(target);
            if (compare == 0) {
                if (subroot.right != null) {
                    return findMin(subroot.right);
                }
            } else if (compare < 0) {
                return findSuccessor(subroot.right, target);
            } else {
                return findSuccessor(subroot.left, target);
            }
        }
        return null;
    }
    // finding the predecessor of a node
    public E findPredecessor(E target) {
        return findPredecessor(root, target);
    }
    private E findPredecessor(Node<E> subroot, E target) {
        if (subroot != null) {
            int compare = subroot.value.compareTo(target);
            if (compare == 0) {
                if (subroot.left != null) {
                    return findMax(subroot.left);
                }
            } else if (compare < 0) {
                return findPredecessor(subroot.right, target);
            } else {
                return findPredecessor(subroot.left, target);
            }
        }
        return null;
    }
    // deleting a node from the tree
    public boolean delete(E target) {
        return delete(null, root, target);
    }
    private boolean delete(Node<E> parent, Node<E> subroot, E target) {
        boolean deleted = false;
        if (subroot != null) {
            int compare = subroot.value.compareTo(target);
            if (compare == 0) { // if the node is found
                deleted = true;
                if (subroot.left == null && subroot.right == null) { // if the node has no children
                    if (parent == null) {
                        root = null;
                    } else if (parent.left == subroot) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (subroot.left == null) { // if the node has only a right child
                    if (parent == null) {
                        root = subroot.right;
                    } else if (parent.left == subroot) {
                        parent.left = subroot.right;
                    } else {
                        parent.right = subroot.right;
                    }
                } else if (subroot.right == null) { // if the node has only a left child
                    if (parent == null) {
                        root = subroot.left;
                    } else if (parent.left == subroot) {
                        parent.left = subroot.left;
                    } else {
                        parent.right = subroot.left;
                    }
                } else { // if the node has two children
                    Node<E> successor = subroot.right;
                    while (successor.left != null) {
                        successor = successor.left;
                    }
                    subroot.value = successor.value;
                    deleted = delete(subroot, subroot.right, successor.value);
                }
            } else if (compare < 0) {
                deleted = delete(subroot, subroot.right, target);
            } else {
                deleted = delete(subroot, subroot.left, target);
            }
        }
        return deleted;
    }

    //inserting a node into the tree
    public boolean insert(E target) {
        return insert(null, root, target);
    }
    private boolean insert(Node<E> parent, Node<E> subroot, E target) {
        boolean inserted = false;
        if (subroot == null) {
            if (parent == null) {
                root = new Node<>(target); // if the tree is empty
            } else if (parent.value.compareTo(target) < 0) {
                parent.right = new Node<>(target);
            } else {
                parent.left = new Node<>(target);
            }
            inserted = true;
        } else {
            int compare = subroot.value.compareTo(target);
            if (compare == 0) {
                inserted = false;
            } else if (compare < 0) {
                inserted = insert(subroot, subroot.right, target);
            } else {
                inserted = insert(subroot, subroot.left, target);
            }
        }
        return inserted;
    }
    // extra helper methods
// get the value of the root
    public E getRoot() {
        return root.value;
    }
    // get the value of the left child of the root
    public E getLeft() {
        return root.left.value;
    }
    // get the value of the right child of the root
    public E getRight() {
        return root.right.value;
    }

    //set the value of root
    public void setRoot(E value) {
        root.value = value;
    }


  // set the value of the left child of the root
    public void setLeft(E value) {
        root.left.value = value;
    }



    // set the value of the right child of the root
    public void setRight(E value) {
        root.right.value = value;
    }

    // convenience methods to build trees

   // build the tree using the root, left and right children and generic
    public static <E extends Comparable<? super E>> Node<E> tree(E value, Node<E> left, Node<E> right) {
        return new Node<>(value, left, right);
    }

   // build the left subtree of the tree using the root and left child and generic
    public static <E extends Comparable<? super E>> Node<E> treeLeft(E value, Node<E> left) {
        return new Node<>(value, left, null);
    }
  // right subtree of the tree using the root and right child and generic
    public static <E extends Comparable<? super E>> Node<E> treeRight(E value, Node<E> right) {
        return new Node<>(value, null, right);
    }

   //leaf node of the tree using the root and no children and generic
    public static <E extends Comparable<? super E>> Node<E> leaf(E value) {
        return new Node<>(value, null, null);
    }





}
