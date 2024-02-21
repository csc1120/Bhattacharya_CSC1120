package Week5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Write a method that would tell you all the ages of the people in a list full of people objects as
//a list of integers. The people class has a getAge() method. Don't use a loop and you must use a
//method reference.
public class ExamReview1 {
    public static void main(String[] args) {
        ArrayList<People> peopleList = new ArrayList<>();
        peopleList.add(new People("John", 25));
        peopleList.add(new People("Jane", 30));
        peopleList.add(new People("Jack", 35));
        peopleList.add(new People("Jill", 40));

        // Write a method that would tell you all the ages of the people in a list full of people objects as
        //a list of integers. The people class has a getAge() method. Don't use a loop and you must use a
        //method reference.
        List<Integer> ages = peopleList.stream().map(People::getAge).collect(Collectors.toList());
        System.out.println(ages);

    // array of 1-10 numbers
    ArrayList<Integer> intList = new ArrayList<>();
    for (int i = 1; i <= 30; i++) {
        intList.add(i);
    }
// return a list of numbers that start with the number 2 using stream

        intList.stream().filter(x -> x.toString().startsWith("2")).collect(Collectors.toList());



    intList.stream().map(x -> x * x).forEach(System.out::println);
// get the sum of the squares of the numbers
    int sum = intList.stream().map(x -> x * x).reduce(0, Integer::sum);
    System.out.println("The sum of the squares of the numbers is: " + sum);
    // get numbers divisible by 2
    List<Integer> divisibleBy2 = intList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    System.out.println(divisibleBy2);
    // find the first number divisible by 2
    int firstDivisibleBy2 = intList.stream().filter(x -> x % 2 == 0).findFirst().get();
    System.out.println(firstDivisibleBy2);

    //String array
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("apple");
    stringList.add("banana");
    stringList.add("cherry");
    stringList.add("date");

    // get the length of each string
    List<Integer> stringLengths = stringList.stream().map(String::length).collect(Collectors.toList());
    System.out.println(stringLengths);
        // get the first string that starts with "c"
        String firstStringWithC = stringList.stream().filter(x -> x.startsWith("a")).findFirst().get();
        // filter the strings that have length greater than 5
        List<String> stringsWithLengthGreaterThan5 = stringList.stream().filter(x -> x.length() > 5).collect(Collectors.toList());
        System.out.println(stringsWithLengthGreaterThan5);
        // replace each string with its uppercase
        List<String> upperCaseStrings = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseStrings);
        // remove the strings that have length less than 5
        List<String> stringsWithLengthLessThan5 = stringList.stream().filter(x -> x.length() < 5).collect(Collectors.toList());
    }
}
