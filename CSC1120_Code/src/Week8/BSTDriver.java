package Week8;

import java.util.function.Consumer;

public class BSTDriver {
//    public static void main(String[] args) {
//        BinaryTree<String> tree = new BinaryTree<>("opposites",
//                new BinaryTree<>("happy"),
//                new BinaryTree<>("sad"));
//        System.out.println(tree);
//    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(4);
        bst.add(0);
        bst.add(17);
        bst.add(38);
        bst.add(-9);
       System.out.println(bst.contains(3));
//        System.out.println(bst.contains(-9));
       System.out.println("size " + bst.size());
       System.out.println("height "+bst.height());
        System.out.println("Preorder");
       bst.postOrder(System.out::println);
        System.out.println("Inorder");
         bst.inOrder(System.out::println);
        System.out.println("Postorder");
        bst.preOrder(System.out::println);
        // print the tree
        System.out.println("toString");
        System.out.println(bst);
        /**
         * Inorder => Left, Root, Right.
         *
         * Preorder => Root, Left, Right.
         *
         * Post order => Left, Right, Root.
         */
    }
}
