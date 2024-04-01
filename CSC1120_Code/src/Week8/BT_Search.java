package Week8;
// breath first search and depth first search in a binary tree
public class BT_Search {
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<>("opposites",
                new BinaryTree<>("happy",
                        new BinaryTree<>("joyful"),
                        new BinaryTree<>("sad")),
                new BinaryTree<>("sad",
                        new BinaryTree<>("miserable"),
                        new BinaryTree<>("glad")));
        System.out.println(tree);
        String target = "miserable";
        System.out.println("Breadth First Search");
       // search for a target in the tree
        //System.out.println(tree.breadthFirstSearch(target));
        tree.breadthFirstSearch(System.out::println);
        System.out.println("Depth First Search");

        tree.depthFirstSearch(System.out::println);
    }
}
