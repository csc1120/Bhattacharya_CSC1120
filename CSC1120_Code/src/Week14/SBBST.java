package Week14;


// An AVL Tree node

    // AVL Tree implementation

    public class SBBST {
        public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree();
            AVLTree avl = new AVLTree();
            // unbalanced keys
            int[] keys = {10, 20, 30, 40, 50, 60};

            for (int key : keys) {
                bst.insert(key);
                avl.insert(key);
            }

            System.out.println("Height of BST: " + bst.height());
            System.out.println("Height of AVL: " + avl.height());
            System.out.printf("AVL balance factor: %d%n", avl.getBalance(avl.root))   ;

            System.out.println("Binary Search Tree:");
            bst.printTree();
            System.out.printf("%n ------------------------------------ %n");
            System.out.println("AVL Tree:");
            avl.printTree();
           // avl.printTree(avl.root, 0);
        }
    }

