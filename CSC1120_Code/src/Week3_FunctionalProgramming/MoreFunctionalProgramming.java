package Week3_FunctionalProgramming;

import java.util.stream.IntStream;

public class MoreFunctionalProgramming {
    public static void main(String[] args) {
        int[] values= {1,4,3,2,5, 6,7,8,9,10};
        //
        System.out.println("Count "+IntStream.of(values).count());
        System.out.println("Max "+IntStream.of(values).max().getAsInt());
        System.out.println("Count "+IntStream.of(values).sum());
        System.out.println("Count "+IntStream.of(values).average().getAsDouble());
        // sorted even numbers
        IntStream.of(values)
                .filter(value -> value%2==0)
                .sorted()
                .forEach(value -> System.out.printf("%d ",value));
        System.out.println();



    }
}
