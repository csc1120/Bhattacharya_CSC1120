package Week11;

import java.util.Objects;

public class Hash {
    public static void main(String[] args) {
        String stringOne = "test";
        String stringTwo = "test";
        // A hashcode is a numeric representation of the contents of an object.
        // The hashcode is used to quickly compare objects.
        int hashCode1 = Objects.hashCode(stringOne);
        int hashCode2 = Objects.hashCode(stringTwo);
        System.out.println("Hash code for stringOne: " + hashCode1);
        System.out.println("Hash code for stringTwo: " + hashCode2);
        assert hashCode1 == hashCode2;
    }
}
