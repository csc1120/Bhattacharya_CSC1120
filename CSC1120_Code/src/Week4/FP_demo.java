package Week4;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP_demo {
    // Use lambda expressions to implement the Predicate, Function, Consumer, and Comparator interfaces
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(5)); // false

        // Function
        Function<Integer, Integer> square = n -> n * n;
        System.out.println(square.apply(4)); // 16
        System.out.println(square.apply(5)); // 25

        // Consumer
        Consumer<String> print = s -> System.out.println(s);
        print.accept("Hello, World!"); // Hello, World!

        // Comparator
        Comparator<Integer> compare = (a, b) -> a - b;
        System.out.println(compare.compare(4, 5)); // -1
        System.out.println(compare.compare(5, 4)); // 1
        System.out.println(compare.compare(4, 4)); // 0
    }
}
