package Week10;
import Week7d.Queue;
public class BinaryTree {
    private String data;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(String data) {
        this(data, null, null);
    }

    public BinaryTree(String data, BinaryTree left, BinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "data='" + data + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    // search method
    public boolean search(String data) {
        if (this.data.equals(data)) {
            return true;
        } else {
            if (left != null && left.search(data)) {
                return true;
            }
            if (right != null && right.search(data)) {
                return true;
            }
        }
        return false;
    }
    // find the height of the tree
    public int height() {
        return height(this);
    }
    private int height(BinaryTree subroot) {
        int count = 0;
        if (subroot != null) {
            count = 1 + Math.max(height(subroot.left), height(subroot.right));
        }
        return count;
    }
    // find the size of the tree
    public int size() {
        return size(this);
    }
    private int size(BinaryTree subroot) {
        int count = 0;
        if (subroot != null) {
            count = 1 + size(subroot.left) + size(subroot.right);
        }
        return count;
    }
    //find Max element without recursion using math.max
    public int findMaxRecursive() {
        return findMaxRecursive(this);
    }
    private int findMaxRecursive(BinaryTree subroot) {
        int max = Integer.parseInt(subroot.data);
        if (subroot != null) {
            max = Math.max(max, findMaxRecursive(subroot.left));
            max = Math.max(max, findMaxRecursive(subroot.right));
        }
        return max;
    }
    // delete a node from the tree
    public void delete(String data) {
        if (this.data.equals(data)) {
            this.data = null;
        } else {
            if (left != null) {
                left.delete(data);
            }
            if (right != null) {
                right.delete(data);
            }
        }
    }
    // breadth first traversal
    public void breadthFirst() {
        Queue<BinaryTree> queue = new Queue<>();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            BinaryTree current = queue.dequeue();
            System.out.println(current.data);
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }
    // depth first traversal
    public void depthFirst() {
        depthFirst(this);
    }
    private void depthFirst(BinaryTree subroot) {
        if (subroot != null) {
            System.out.println(subroot.data);
            depthFirst(subroot.left);
            depthFirst(subroot.right);
        }
    }



    // find the max element

}
