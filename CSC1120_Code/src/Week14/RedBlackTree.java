package Week14;

public class RedBlackTree {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private class Node {
        int data;
        Node left, right;
        boolean color;

        Node(int data) {
            this.data = data;
            this.color = RED;
            this.left = this.right = null;
        }
    }

    private Node root;

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void insert(int data) {
        root = insert(root, data);
        root.color = BLACK;
    }

    private Node insert(Node node, int data) {
        if (node == null) return new Node(data);

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            node.data = data;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }
    // delete method
    public void delete(int data) {
        root = delete(root, data);
        if (root != null) root.color = BLACK;
    }
    private Node delete(Node node, int data) {
        if (node == null) return null;

        if (data < node.data) {
            if (!isRed(node.left) && !isRed(node.left.left)) {
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, data);
        } else {
            if (isRed(node.left)) {
                node = rotateRight(node);
            }
            if (data == node.data && node.right == null) {
                return null;
            }
            if (!isRed(node.right) && !isRed(node.right.left)) {
                node = moveRedRight(node);
            }
            if (data == node.data) {
                Node temp = min(node.right);
                node.data = temp.data;
                node.right = deleteMin(node.right);
            } else {
                node.right = delete(node.right, data);
            }
        }
        return balance(node);
    }

    private Node deleteMin(Node right) {
        if (right.left == null) {
            return null;
        }
        if (!isRed(right.left) && !isRed(right.left.left)) {
            right = moveRedLeft(right);
        }
        right.left = deleteMin(right.left);
        return balance(right);
    }

    private Node balance(Node right) {
        if (isRed(right.right)) {
            right = rotateLeft(right);
        }
        if (isRed(right.left) && isRed(right.left.left)) {
            right = rotateRight(right);
        }
        if (isRed(right.left) && isRed(right.right)) {
            flipColors(right);
        }
        return right;
    }

    private Node min(Node right) {
        Node current = right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node moveRedRight(Node node) {
        flipColors(node);
        if (isRed(node.left.left)) {
            node = rotateRight(node);
            flipColors(node);
        }
        return node;
    }

    private Node moveRedLeft(Node node) {
        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            flipColors(node);
        }
        return node;
    }


    // Method to print the binary tree visually with dashes
    public void printTree() {
        printTreeNode(root, 0, "");
    }

    private void printTreeNode(Node current, int level, String prefix) {
        if (current == null) {
            return;
        }

        printTreeNode(current.right, level + 1, "     ");

        // Print the current node after space count
        if (level != 0) {
            // Print leading dashed lines for branches
            System.out.println(" ".repeat(level * 8 - 4) + prefix + "----" + current.data);
        } else {
            System.out.println(" ".repeat(level * 2) + prefix + current.data);
        }

        printTreeNode(current.left, level + 1, "      ");
    }
}
