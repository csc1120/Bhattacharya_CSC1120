package Week14;

// An AVL Tree node
class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 1;
    }
}

// AVL Tree implementation
class AVLTree {
    AVLNode root;

    // A utility function to get the height of the tree
    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get the maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }


    // A utility function to right rotate subtree rooted with y
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    // balance factor is the difference between the height of the left subtree and right subtree

    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Recursive function to insert a key in the subtree rooted with node and
    // returns the new root of the subtree.
    AVLNode insert(AVLNode node, int key) {
        // 1. Perform the normal BST insertion
        if (node == null)
            return (new AVLNode(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        // 2. Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Get the balance factor of this ancestor node to check whether
        // this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case - here we need to do a right rotation left left case is when the balance factor is greater than 1 and the key is less than the left node key
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key) // right right case is when the balance factor is less than -1 and the key is greater than the right node key
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) { // left right case is when the balance factor is greater than 1 and the key is greater than the left node key
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) { // right left case is when the balance factor is less than -1 and the key is less than the right node key
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // return the (unchanged) node pointer
        return node;
    }
    void  delete(int key){
        root = delete(root, key);
    }
    AVLNode delete(AVLNode root, int key){
        if (root == null)
            return root;
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)){
                AVLNode temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null){
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else {
                AVLNode temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }
        if (root == null)
            return root;
        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        if (balance > 1 && getBalance(root.left) < 0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private AVLNode minValueNode(AVLNode right) {
        AVLNode current = right;
        while (current.left != null)
            current = current.left;
        return current;
    }

    void insert(int key) {
        root = insert(root, key);
    }

    int height() {
        return height(root);
    }
    // Method to print the binary tree visually with dashes
    public void printTree() {
        printTreeNode(root, 0, "");
    }

    private void printTreeNode(AVLNode current, int level, String prefix) {
        if (current == null) {
            return;
        }

        printTreeNode(current.right, level + 1, "     ");

        // Print the current node after space count
        if (level != 0) {
            // Print leading dashed lines for branches
            System.out.println(" ".repeat(level * 8 - 4) + prefix + "----" + current.key);
        } else {
            System.out.println(" ".repeat(level * 2) + prefix + current.key);
        }

        printTreeNode(current.left, level + 1, "      ");
    }

}

