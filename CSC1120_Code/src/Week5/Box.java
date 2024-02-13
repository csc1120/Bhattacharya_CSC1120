package Week5;

/**
 * This class represents a Box that holds objects of a specific type,
 * where the type ("T") is specified at time of creation.
 *
 * @param <T> the type of the object held by the Box
 */
public class Box<T> {
    private T t; // T stands for "Type"

    /**
     * Set the object within this box. The object must be of correct type.
     *
     * @param t the object to be added to the box
     */
    public void set(T t) {
        this.t = t;
    }

    /**
     * Retrieve the object within this box.
     *
     * @return the object contained within the box
     */
    public T get() {
        return t;
    }

    /**
     * The main method creates and interacts with Box objects holding different types.
     * Box for Integer and Box for String are demonstrated.
     *
     * @param args Unused command line arguments.
     */
    public static void main(String[] args) {
        // Create instance of Box for Integers
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10); // Autoboxing converts int to Integer
        Integer someInteger = integerBox.get();
        System.out.println(someInteger);

        // Create instance of Box for Strings
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        String someString = stringBox.get();
        System.out.println(someString);
    }
}