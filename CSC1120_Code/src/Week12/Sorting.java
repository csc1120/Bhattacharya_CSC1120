package Week12;

import java.util.*;

public class Sorting {
    public static final int N = 1_000;
    public static final Random generator = new Random();

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(generator.nextInt(0, 500));
        }

        System.out.format("%,14d SelectionSort1 ", benchmark(nums, list -> selectionSort1(list)));
        System.out.println(isSorted(nums));
        //Collections.shuffle(nums);
        System.out.format("%,14d SelectionSort2 ", benchmark(nums, list -> selectionSort2(list)));
        System.out.println(isSorted(nums));
        //Collections.shuffle(nums);
        System.out.format("%,14d SelectionSort3 ", benchmark(nums, list -> selectionSort3(list)));
        System.out.println(isSorted(nums));
        //Collections.shuffle(nums);
        System.out.format("%,14d SelectionSortUW ", benchmark(nums, list -> selectionSortUW(list)));
        System.out.println(isSorted(nums));
        System.out.format("%,14d SelectionSortUW ", benchmark(nums, list -> selectionSortUW(list)));
        //Collections.shuffle(nums);

        System.out.format("%,14d InsertionSort1 ", benchmark(nums, list -> insertionSort1(list)));
        System.out.println(isSorted(nums));
        System.out.format("%,14d InsertionSort1 ", benchmark(nums, list -> insertionSort1(list)));
        Collections.shuffle(nums);
        //System.out.format("%,14d InsertionSort2 ", benchmark(nums, list -> insertionSort2(list)));
        //System.out.println(isSorted(nums));
        //Collections.shuffle(nums);
        System.out.format("%,14d InsertionSort3 ", benchmark(nums, list -> insertionSort3(list)));
        System.out.println(isSorted(nums));
        System.out.format("%,14d InsertionSort3 ", benchmark(nums, list -> insertionSort3(list)));
        //Collections.shuffle(nums);
        System.out.format("%,14d InsertionSortArrayList ", benchmark(nums, list -> insertionSortArrayList(list)));
        System.out.println(isSorted(nums));
        System.out.format("%,14d InsertionSortArrayList ", benchmark(nums, list -> insertionSortArrayList(list)));
        //Collections.shuffle(nums);

        System.out.format("%,14d Collections ", benchmark(nums, list -> Collections.sort(list)));
        System.out.println(isSorted(nums));
    }

    public static long benchmark(List<Integer> list, Sorter sorter) {
        long start = System.nanoTime();
        sorter.sort(list);
        return System.nanoTime() - start;
    }

    public static <E> boolean isSorted(List<? extends Comparable<E>> list) {
        boolean sorted = true;
        Iterator<? extends Comparable<E>> itr = list.iterator();
        E smaller = null;
        if (itr.hasNext()) {
            smaller = (E) itr.next();
        }
        while (sorted && itr.hasNext()) {
            sorted = itr.next().compareTo(smaller) >= 0;
        }
        return sorted;
    }

    public static <E> void selectionSort1(List<? extends Comparable<E>> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo((E) list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(list, i, minIndex);
        }
    }

    public static void selectionSort2(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if ((list.get(j)).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Integer temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    public static void selectionSort3(List<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            Integer smol = list.get(j);
            Integer current;
            for (int i = j; i < list.size(); i++) {
                current = list.get(i);
                if (smol.compareTo(current) > 0) {
                    list.set(i, smol);
                    smol = current;
                }
            }
            list.set(j, smol);
        }
    }

    public static void selectionSortUW(List<Integer> data) {
        // https://pages.cs.wisc.edu/~yinggang/courses/cs302/summer_2012/Example_Code/Lecture_13/

        // declare an int variable to hold value of index at which the element
        // has the smallest value
        int smallestIndex;

        // declare an int variable to hold the smallest value for each iteration
        // of the outer loop
        int smallest;

        // for each index in the array list
        for (int curIndex = 0; curIndex < data.size(); curIndex++) {

            /* find the index at which the element has smallest value */
            // initialize variables
            smallest = data.get(curIndex);
            smallestIndex = curIndex;

            for (int i = curIndex + 1; i < data.size(); i++) {
                if (smallest > data.get(i)) {
                    // update smallest
                    smallest = data.get(i);
                    smallestIndex = i;
                }
            }

            /* swap the value */
            // do nothing if the curIndex has the smallest value
            if (smallestIndex == curIndex)
                ;
                // swap values otherwise
            else {
                int temp = data.get(curIndex);
                data.set(curIndex, data.get(smallestIndex));
                data.set(smallestIndex, temp);
            }
        }
    }

    public static <E> void insertionSort1(List<? extends Comparable<E>> list) {
        if(list == null) {
            throw new IllegalArgumentException();
        }
        for(int x = 0; x < list.size(); x++) {
            for(int y = x; (y > 0) && (list.get(y).compareTo((E) list.get(y - 1)) < 0); y--) {
                Collections.swap(list, y, y-1);
            }
        }
    }

    public static void insertionSort2(List<Integer> list) {
        for ( int i = 0; i < list.size() - 1; i++) {
            Integer min = list.get(i);
            for( int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < min) {
                    list.set(i, list.get(j));
                    list.set(j, min);
                    j = list.size();
                }
            }
        }
    }

    public static void insertionSort3(List<Integer> list) {
        int sortedTo = 0;
        while(sortedTo != list.size()) {
            Integer currentMin = list.get(0);
            int mindex = 0;
            for(int i = 0; i < list.size() - sortedTo; i++) {
                if(list.get(i).compareTo(currentMin) < 0) {
                    currentMin = list.get(i);
                    mindex = i;
                }
            }

            list.add(list.get(mindex));
            list.remove(mindex);
            sortedTo++;
        }
    }

    public static void insertionSortArrayList(List<Integer> list) {
        // https://codegym.cc/groups/posts/insertion-sort-in-java
        for (int j = 1; j < list.size(); j++) {
            Integer current = list.get(j);
            int i = j-1;
            while ((i > -1) && ((list.get(i).compareTo(current)) == 1)) {
                list.set(i+1, list.get(i));
                i--;
            }
            list.set(i+1, current);
        }
    }
}