/*<listing chapter="6" section="3">*/
package Week14.KW.CH06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Class for a binary tree that stores type E objects.
 *
 * @param <E> The element type
 * @author Koffman and Wolfgang
 *
 */
public class BinaryTree<E> 
        /*<exercise chapter="6" type="programming-project" number="4">*/
        implements Cloneable,
        /*</exercise>*/
        /*<exercise chapter="6" type="programming-project" number="7">*/
        Iterable<E>
        /*</exercise>*/    
{

    /*<listing chapter="6" number="1">*/
    /**
     * Class to encapsulate a tree node.
     *
     * @param <E> The element type
     */
    public static class Node<E>
    /*<exercise chapter="6" type="programming-exercise" number="4">*/
            implements Cloneable
    /*</exercise>*/
    {
        // Data Fields

        /**
         * The information stored in this node.
         */
        public E data;
        /**
         * Reference to the left child.
         */
        public Node<E> left;
        /**
         * Reference to the right child.
         */
        public Node<E> right;

        // Constructors
        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        @Override
        public String toString() {
            return data.toString();
        }
        
        /**
         * Make a clone of the tree that has this node as the root.
         * @return A deep copy of this tree.
         */
        @Override
        @SuppressWarnings("unchecked")
        public Node<E> clone() {
            try {
                var theClone = (Node<E>) super.clone();
                if (theClone.left != null) {
                    theClone.left = theClone.left.clone();
                }
                if (theClone.right != null) {
                    theClone.right = theClone.right.clone();
                }
                return theClone;
            } catch (CloneNotSupportedException ex) {
                throw new InternalError();
            }
        }


    }
    /*</listing>*/
    // Data Field
    /**
     * The root of the binary tree
     */
    public Node<E> root;

    /**
     * Construct an empty BinaryTree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a BinaryTree with a specified root. Should only be used by
     * subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree as its left
     * subtree and rightTree as its right subtree.
     *
     * @param data The data item to store in the root
     * @param leftTree the left child
     * @param rightTree the right child
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
            BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or the left subtree
     * is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or null if either the root or the right
     * subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Return the data field of the root
     *
     * @return the data field of the root or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root == null || (root.left == null && root.right == null));
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        preOrderTraverse((e, d) -> {
            for (int i = 1; i < d; i++) {
                sb.append("  ");
            }
            sb.append(e);
            sb.append("\n");
        });
        return sb.toString();
    }

    /*<listing chapter="6" section="4">
    /**
     * Starter method for preorder traversal
     * @param consumer an object that instantiates the BiConsumer interface.
     *        Its method implements the abstract method apply.
     */
    public void preOrderTraverse(BiConsumer<E, Integer> consumer) {
        preOrderTraverse(root, 1, consumer);
    }

    /**
     * Performs a recursive pre-order traversal of the tree,
     * applying the action specified in the consumer object.
     * @param node The local root
     * @param depth The depth
     * @param consumer object whose accept method specifies the action 
     * to be performed on each node.
     */
    private void preOrderTraverse(Node<E> node, int depth, 
            BiConsumer<E, Integer> consumer) {
        if (node == null) {
            consumer.accept(null, depth);
        } else {
            consumer.accept(node.data, depth);
            preOrderTraverse(node.left, depth + 1, consumer);
            preOrderTraverse(node.right, depth + 1, consumer);
        }
    }
    /*</listing>*/

    /*<exercise chapter="6" section="4" type="programming" number="4">*/
    /**
     * Perform a post-order traversal of the tree.
     * Performs a post-order traversal of the tree passing each node and 
     * the node's depth to the consumer function.
     * @param consumer The consumer of each node
     */
    public void postOrderTraverse(BiConsumer<E, Integer> consumer) {
        postOrderTraverse(root, 1, consumer);
    }

    /**
     * Perform a pre-order traversal.
     * Performs a pre-order traversal of the subtree whose root is at node
     * passing the node and the depth to the consumer function.
     * @param node The local root
     * @param depth The depth
     * @param consumer The consumer of each node
     */
    private void postOrderTraverse(Node<E> node, int depth, 
            BiConsumer<E, Integer> consumer) {
        if (node == null) {
            consumer.accept(null, depth);
        } else {
            postOrderTraverse(node.left, depth + 1, consumer);
            postOrderTraverse(node.right, depth + 1, consumer);
            consumer.accept(node.data, depth);
        }
    }
    /*</exercise>*/

    /*<exercise chapter="6" section="4" type="programming" number="5">*/
    /**
     * Perform a in-order traversal of the tree.
     * Performs a in-order traversal of the tree passing each node and 
     * the node's depth to the consumer function.
     * @param consumer The consumer of each node
     */
    public void inOrderTraverse(BiConsumer<E, Integer> consumer) {
        inOrderTraverse(root, 1, consumer);
    }

    /**
     * Perform a in-order traversal.
     * Performs a in-order traversal of the subtree whose root is at node
     * passing the node and the depth to the consumer function.
     * @param node The local root
     * @param depth The depth
     * @param consumer The consumer of each node
     */
    private void inOrderTraverse(Node<E> node, int depth, 
            BiConsumer<E, Integer> consumer) {
        if (node == null) {
            consumer.accept(null, depth);
        } else {
            inOrderTraverse(node.left, depth + 1, consumer);
            consumer.accept(node.data, depth);
            inOrderTraverse(node.right, depth + 1, consumer);
        }
    }
    /*</exercise>*/
    
    /*<listing chapter="6" number="2">*/
    /**
     * Method to read a binary tree.
     *
     * prehe input consists of a pre-order traversal of the binary tree. The
     * line &quot;null&quot; indicates a null tree.
     * @param scan the Scanner attached to the input file
     * @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        // Read a line and trim leading and trailing spaces.
        String data = scan.nextLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data, leftTree, rightTree);
        }
    }
    /*</listing>*/

    /*<exercise chapter="6" section="3" type="programming" number="1">*/
    /**
     * Method to return the pre-order traversal of the binary tree as a sequence
     * of strings each separated by a space.
     *
     * @return A pre-order traversal as a string
     */
    public String preorderToString() {
        return preorderToString(root);
    }

    private String preorderToString(Node<E> node) {
        StringJoiner sj = new StringJoiner(" ");
        sj.add(node.toString());
        if (node.left != null) {
            sj.add(preorderToString(node.left));
        }
        if (node.right != null) {
            sj.add(preorderToString(node.right));
        }
        return sj.toString();
    }
    /*</exercise>*/

    /*<exercise chapter="6" section="3" type="programming" number="2">*/
    /**
     * Method to return the post-order traversal of the binary tree as a
     * sequence of strings each separated by a space.
     *
     * @return A post-order traversal as a string
     */
    public String postorderToString() {
        return postorderToString(root);
    }

    private String postorderToString(Node<E> node) {
        StringJoiner sj = new StringJoiner(" ");
        if (node.left != null) {
            sj.add(postorderToString(node.left));
        }
        if (node.right != null) {
            sj.add(postorderToString(node.right));
        }
        sj.add(node.toString());
        return sj.toString();
    }
    /*</exercise>*/

    /*<exercise chapter="6" section="3" type="programming" number="3">*/
    /**
     * A method to display the in-order traversal of a binary tree placing a
     * left parenthesis before each subtree and a right parenthesis after each
     * subtree. For example the expression tree shown in Figure 6.12 would be
     * represented as (((x) + (y)) * ((a) / (b))).
     *
     * @return An in-order string representation of the tree
     */
    public String inorderToString() {
        return inorderToString(root);
    }

    private String inorderToString(Node<E> node) {
        StringJoiner sj = new StringJoiner(" ", "(", ")");
        if (node.left != null) {
            sj.add(inorderToString(node.left));
        }
        sj.add(node.toString());
        if (node.right != null) {
            sj.add(inorderToString(node.right));
        }
        return sj.toString();
    }
    /*</exercise>*/
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof BinaryTree) {
            var other = (BinaryTree<?>) o;
            if (!getData().equals(other.getData())) return false;
            else return Objects.equals(getLeftSubtree(), other.getLeftSubtree())
                    && Objects.equals(getRightSubtree(), other.getRightSubtree());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.root);
        hash += 43 * Objects.hashCode(getLeftSubtree());
        hash += 17 * Objects.hashCode(getRightSubtree());
        return hash;
    }
    
    /*<exercise chapter="6" type="programming-project" number="7">*/
    public Iterator<E> iterator() {
        return new InOrderIterator(root);
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected class InOrderIterator implements Iterator<E> {
 
        Node next;
        
        Deque<Node> stack = new ArrayDeque<>();
        
        InOrderIterator(Node root) {
            if (root != null) {
                findLeftMostChild(root);
            } else {
                next = null;
            }
        }
        
        private void findLeftMostChild(Node root) {
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }
            next = root;
        }
        
        private void advance() {
            if (next.right != null) {
                findLeftMostChild(next.right);
            } else {
                if (stack.isEmpty()) {
                    next = null;
                } else {
                    next = stack.pop();
                }
            }
        }
        
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            var returnValue = next.data;
            advance();
            return (E)returnValue;
        }     
    }
    /*</exercise>*/
    
    /*<exercise chapter="6" type="programming-project" number="4">*/
    
    /**
     * Return the height of the tree.
     * @return the height of the tree.
     */
    public int height() {
        if (root == null) return 0;
        int leftHeight = getLeftSubtree().height();
        int rightHeight = getRightSubtree().height();
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    /**
     * Return the size of the tree.
     * @return the size of the tree
     */
    public int size() {
        if (root == null) return 0;
        return 1 + getLeftSubtree().size() + getRightSubtree().size();
    }
    
    /**
     * Make a clone of this tree.
     * @return A deep copy of this tree.
     */
    @Override
    public BinaryTree<E> clone() {
        try {
            @SuppressWarnings("unchecked")
			BinaryTree<E> theClone = (BinaryTree<E>) super.clone();
            if (theClone.root != null) {
                theClone.root = theClone.root.clone();
            }
            return theClone;
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
	/*</exercise>*/

    /*<exercise chapter="6" type="programming-project" number="5">*/
    /** Perform a breadth-first traversal.
     * In a breadth-first traversal of a binary tree, the nodes are visited 
     * in an order prescribed by their level. First visit the node at level 1, 
     * the root node. Then visit the nodes at level 2, in left-to-right order, 
     * and so on.
     * @param consumer The consumer of each node
     */
    public void bredthFirstTrverse(Consumer<E> consumer) {
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            consumer.accept(node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
    /*</exercise>*/


}
/*</listing>*/
