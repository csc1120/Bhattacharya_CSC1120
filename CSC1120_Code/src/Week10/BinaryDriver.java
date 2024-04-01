package Week10;

public class BinaryDriver {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree("B",
                new BinaryTree("E",
                        new BinaryTree("G"),
                        new BinaryTree("E")),
                new BinaryTree("C",
                        new BinaryTree("A"),
                        new BinaryTree("F")));
        System.out.println(tree);

        // breadth first traversal
        tree.breadthFirst();

    }
}
