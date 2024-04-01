package Week8;

import java.util.function.Consumer;
// Consumer is a functional interface that takes a single input and returns no result
// Comparable is a functional interface that takes a single input and returns an int
// The int is negative if the input is less than the object being compared to
// The int is positive if the input is greater than the object being compared to
// The int is 0 if the input is equal to the object being compared to
public class BST<E extends Comparable<? super E>> {
    static final class Node<E> {
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

    public Node<E> root;

    public BST() {
        root = null;
    }

    public void preOrder(Consumer<E> element) {
        preOrder(root, element);
    }

    // preOrder is a method that takes a Consumer and a Node
// It returns nothing
    private void preOrder(Node<E> subroot, Consumer<E> element) {
        if (subroot != null) {
            element.accept(subroot.value); // accept is a method that takes a single input and returns no result
            preOrder(subroot.left, element);
            preOrder(subroot.right, element);
        }
    }
// inOrder is a method that takes a Consumer and a Node

    public void inOrder(Consumer<E> element) {
        inOrder(root, element);
    }

    private void inOrder(Node<E> subroot, Consumer<E> element) {
        if (subroot != null) {
            inOrder(subroot.left, element);
            element.accept(subroot.value);
            inOrder(subroot.right, element);
        }
    }

    public void postOrder(Consumer<E> element) {
        postOrder(root, element);
    }

    private void postOrder(Node<E> subroot, Consumer<E> element) {
        if (subroot != null) {
            postOrder(subroot.left, element);
            postOrder(subroot.right, element);
            element.accept(subroot.value);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean add(E element) throws StackOverflowError {
        boolean added = false;
        if (isEmpty()) {
            root = new Node<>(element);
            added = true;
        } else {
            added = add(root, element);
        }
        return added;
    }

    private boolean add(Node<E> subroot, E element) throws StackOverflowError {
// add an memory overflow exceptio
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

    // delete a node from the tree
    public boolean delete(E target) {
        return delete(null, root, target);
    }

    private boolean delete(Node<E> parent, Node<E> subroot, E target) {
        boolean deleted = false;
        if (subroot != null) { // if the tree is not empty
            int compare = subroot.value.compareTo(target);
            if (compare == 0) {
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
                    Node<E> successor = subroot.right; // find the smallest value in the right subtree
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

    // find the minimum value in the tree
    public E findMin() {
        return findMin(root);
    }

    private E findMin(Node<E> subroot) {
        E min = null;
        if (subroot != null) {
            if (subroot.left == null) {
                min = subroot.value;
            } else {
                min = findMin(subroot.left);
            }
        }
        return min;
    }
    // non recursive version of findMin
    public E findMinNonRecursive() {
        Node<E> current = root;
        while (current != null) {

            current = current.left;
        }

        return current.value;
    }
    // find the maximum value in the tree non recursive
    public E findMaxNonRecursive() {
        Node<E> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
    // using recursion maximum value in the tree
    public E findMax() {
        return findMax(root);
    }
    private E findMax(Node<E> subroot) {
        E max = null;
        if (subroot != null) {
            if (subroot.right == null) {
                max = subroot.value;
            } else {
                max = findMax(subroot.right);
            }
        }
        return max;
    }


    // clear the tree
    public void clear() {
        root = null;
    }

    public void printTree(Node<E> root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.value);
            printTree(root.right);
        }
    }
}

//print the binary search tree


