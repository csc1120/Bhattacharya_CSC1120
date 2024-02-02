package Week3_FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
        System.out.println("//Imperative method");
        // list of student
        List<Person> students = List.of(
                new Person("Alice", "CSC"),
                new Person("Bob", "SWE"),
                new Person("Eve", "CSC"),
                new Person("Charles", "SWE")
        );

        List<Person> sweStudents = new ArrayList<>();
        // iterate over the list of students and compare the getmajor
        for (Person student : students) {
            if (student.getMajor().equals("SWE")) {
                sweStudents.add(student);
            }
        }
        // print the swe students list
        for (Person student : sweStudents) {
            System.out.println(student);
        }

        // declarative style
        System.out.println("Declarative Style");
        Predicate<Person> personPredicate = person -> person.getMajor().equals("SWE");

        List<Person> sweStudent2 = students.stream().
                                        filter(personPredicate).
                                        collect(Collectors.toList());
        sweStudent2.forEach(System.out::println);

    }
}
