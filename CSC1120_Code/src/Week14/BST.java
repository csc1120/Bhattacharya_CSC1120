package Week14;

import java.util.LinkedList;
import java.util.Queue;

class BSTNode {
    int key;
    BSTNode left, right;

    public BSTNode(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    BSTNode root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    int height() {
        return heightRec(root);
    }

    int heightRec(BSTNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }

    // Method to print the binary tree visually with dashes
    public void printTree() {
        printTreeNode(root, 0, "");
    }

    private void printTreeNode(BSTNode current, int level, String prefix) {
        if (current == null) {
            return;
        }

        printTreeNode(current.right, level + 1, "        ");

        // Print the current node after space count
        if (level != 0) {
            // Print leading dashed lines for branches
            System.out.println("  ".repeat(level * 5 - 3) + prefix + "---" + current.key);
        } else {
            System.out.println(" ".repeat(level) + prefix +" " + current.key);
        }

        printTreeNode(current.left, level + 1, "        ");
    }
    // Method to print the binary tree from top to bottom using level-order traversal
    public void printTopToBottom() {
        if (root == null) return;

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BSTNode node = queue.poll();
            System.out.println(node.key);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    // Method to print the tree from top to bottom with dashes
    public void printTopToBottomWithDashes() {
        printNodeWithDashes(root, 0);
    }

    private void printNodeWithDashes(BSTNode node, int depth) {
        if (node == null) {
            return;
        }
        // Increase depth for sub-levels
        printNodeWithDashes(node.right, depth + 1); // Right child first for visual alignment from right to left

        // Create a string of dashes
        String padding = " ".repeat(depth * 2); // Adjust the number of spaces or dashes as needed
        System.out.println(padding + "  " + node.key);

        printNodeWithDashes(node.left, depth + 1); // Then the left child
    }
}

