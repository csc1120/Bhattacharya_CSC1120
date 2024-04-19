package Week14.KW.CH06;

public class PrintBinaryTree {

        public static <E> void printTree(BinaryTree<E> tree) {
            printTree(tree, 0, tree.root);
        }

        private static <E> void printTree(BinaryTree<E> tree, int level, BinaryTree.Node<E> node) {
            if (node != null) {
                printTree(tree, level + 1, node.right);
                for (int i = 0; i < level; i++) {
                    System.out.print("    ");
                }
                System.out.println(node.data);
                printTree(tree, level + 1, node.left);
            }
        }
}
