package Week3_FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MoreMoreFunctions {
    public void printCities(){
        List<String> cities= new ArrayList<>();
        cities.add("Milwaukee");
        cities.add("Boston");
        cities.add("Boston");
        cities.add("New York");

        // A consumer is an in-build functional interface. Its used when we
        // need to consume objects, the consumet takes an input value
            Consumer<String> printConsumer= System.out::println;
    }

    // filter method

    public  void filterCities(){
        List<String> cities= new ArrayList<>();
        Predicate<String>filterCity= city-> cities.equals("Boston");
        cities.stream().filter(filterCity).forEach(System.out::println);
    }
    // supplier method interface
}
