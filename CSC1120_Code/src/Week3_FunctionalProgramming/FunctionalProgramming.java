package Week3_FunctionalProgramming;
import java.util.stream.IntStream;
public class FunctionalProgramming {
    public static void main(String[] args) {
        // imperative programming
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Imperative style: sum of 1 to 10 is " + sum);

        // InStream is a function programing interface which works on the stream of
        // primitive int values
        int sumA = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Declarative style: sum is "+ sumA);
        // lambda expression
        IntStream.rangeClosed(1,10).forEach(i-> System.out.println(i+" "));
        IntStream.rangeClosed(1,10).forEach(System.out::print); //:: method reference
        // SAM interface using Lambda expression
        int a= 10;
        int b=20;
        Adder adder=(x,y)->x+y;
        System.out.println();
        System.out.println(adder.add(a,b));

    }
    // Single Abstract Method is an interface with only one abstract method
    // SAM can be implemented using lambda expressions
    @FunctionalInterface
    interface  Adder{
        int add(int x, int y);
    }

}