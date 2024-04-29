package Week8;

import java.util.Stack;
import Week8.BST.Node;

class ET1 {

    // Function to check if the given character is an operator
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Function to construct the expression tree
    static Node constructTree(String postfix) {
        Stack<Node> stk = new Stack<>();

        // Traverse through the given expression
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If operand, create a leaf node
            if (!isOperator(c)) {
                stk.push(new Node(c));
            } else {
                // Pop two operands from the stack
                Node node = new Node(c);
                node.right = stk.pop();
                node.left = stk.pop();

                // Push the formed node back to Stack
                stk.push(node);
            }
        }

        // Stack now contains the root of the expression tree
        return stk.pop();
    }

    // Function to perform inorder traversal (infix notation)
    static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    // Function to perform preorder traversal (prefix notation)
    static void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }
    // Function to perform postOrder traversal (postflix notation)
    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }


    public static void main(String args[]) {
        String postfix = "AB+C*";
        String infix = "A+B*C";
        String prefix = "*+ABC";

        Node root = constructTree(postfix);

        System.out.println("Infix expression: ");
        inorder(root);

        System.out.println("\nPrefix expression: ");
        preorder(root);

        System.out.println("\nPostfix expression: ");
        postOrder(root);
    }
}
