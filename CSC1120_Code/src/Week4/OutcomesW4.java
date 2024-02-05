import java.util.*;

public class OutcomesW4 {
    public static void main(String[] args) {
        // Use of Collection with generics
        Collection<String> collection = new HashSet<>();
        collection.add("Apple");
        collection.add("Banana");
        collection.add("Apple");
        collection.forEach(System.out::println);

        // Use of List with generics
        List<String> list = new ArrayList<>();
        list.add("Cat");
        list.add("Dog");
        list.forEach(System.out::println);

        // Use Collection when you don't need to maintain insertion order or allow duplicate elements
        Collection<String> collection2 = new HashSet<>();
        collection2.add("Apple");
        collection2.add("Banana");
        collection2.add("Apple");
        collection2.forEach(System.out::println);
    }
}