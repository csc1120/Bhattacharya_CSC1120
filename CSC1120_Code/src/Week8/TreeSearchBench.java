package Week8;
// Benchmarking the performance of the BST class
// // create tree with n nodes and benchmark the time it takes to search for a node


public class TreeSearchBench {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] n= {10, 100, 1000, 100000};
        int runs = 5;
        // average time to search for a node
        Long[] times = new Long[runs];
        Long average = 0L;
        for (int i = 0; i < runs; i++) {
            times[i]= benchmarkSearch(bst, n[i]);
        }
        for (int i = 0; i < runs; i++) {
            average += times[i];
            System.out.println("Time to search " + n[i] + " nodes: " + times[i] + "ms");
        }
        System.out.println("Average time to search for a node: " + average/runs + "ms");

    }

    private static Long benchmarkSearch(BST<Integer> bst, int i) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            bst.add(j);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time to add " + i + " nodes: " + (end - start) + "ms");
        start = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            bst.contains(j);
        }
        end = System.currentTimeMillis();
        //System.out.println("Time to search " + i + " nodes: " + (end - start) + "ms");
        return end - start;
    }
}
