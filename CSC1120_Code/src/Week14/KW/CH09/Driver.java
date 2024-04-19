package Week14.KW.CH09;

import Week14.KW.CH06.BinarySearchTree;
import Week14.KW.CH06.PrintBinaryTree;

public class Driver {
    public static void main(String[] args) {
// create a binary search tree
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);

        PrintBinaryTree.printTree(tree);
        System.out.println("--------------------");
        AVLTree<Integer> avl = new AVLTree<>();
        avl.add(10);
        avl.add(20);
        avl.add(30);
        avl.add(40);
        avl.add(50);

PrintBinaryTree.printTree(avl);


    }

}
