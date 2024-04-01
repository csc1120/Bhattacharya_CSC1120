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
        bst.add(3);
        bst.add(4);
        bst.add(2);
        bst.add(7);
        bst.add(9);
        System.out.println(bst.findMaxNonRecursive());

        BST2<String> bst2 = new BST2<>();
        bst2.add("A");
        bst2.add("B");
        bst2.add("F");
        bst2.insert("C");
        bst2.add("D");
        bst2.delete("A");
        bst2.insert("A");

        //print the successor of A
        System.out.println(bst2.findSuccessor("A"));
        //print the predecessor of A
        System.out.println(bst2.findPredecessor("D"));

//        bst2.add("C");
//        bst2.add("F");
//        bst2.add("G");


        System.out.println();
        System.out.println("Min " + bst2.findMin());
        System.out.println("Max " + bst2.findMax());


      //  bst.delete(5);
//       System.out.println(bst.contains(3));
//        System.out.println(bst.contains(-9));
       System.out.println("size " + bst.size());
       System.out.println("height "+bst.height());
        //System.out.println(bst.search(-17));
      System.out.println("Preorder");
       bst2.postOrder(System.out::println);
        System.out.println("Inorder");
         bst2.inOrder(System.out::println);
        System.out.println("Postorder");
        bst2.preOrder(System.out::println);
        bst.clear();
        System.out.println("size " + bst.size());
//        // print the tree
//        System.out.println("toString");
//        System.out.println(bst);
        /**
         * Inorder => Left, Root, Right.
         *
         * Preorder => Root, Left, Right.
         *
         * Post order => Left, Right, Root.
         */
    }
}
