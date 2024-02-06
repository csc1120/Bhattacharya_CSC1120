package Week4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShapeDriver {
    public static void main(String[] args) {

        // List of shapes objects
        List<Shape> shapes = new ArrayList<>();
        shapes=List.of(
                new Triangle(10, 5),
                new Circle(5),
                new Triangle(20, 10),
                new Circle(10),
                new Rectangle(10, 5)
        );
        // random shuffle the list of shapes;
        Stream<Shape> shapeStream = shapes.stream();
        List<Shape> shuffledShapes = shapeStream.collect(Collectors.toList());
        Collections.shuffle(shuffledShapes);
        shuffledShapes.forEach(System.out::println);

        System.out.println("**********");
    // filter the list of shapes to get only the circles
        List<Circle> circles = shapes.stream()
                .filter(shape -> shape instanceof Circle)
                .map(shape -> (Circle) shape)
                .collect(Collectors.toList());
        circles.forEach(System.out::println);

// sum of the areas of the shapes
        double sum = shapes.stream()
                .mapToDouble(Shape::area)
                .sum();
        System.out.println("Sum of the areas: " + sum);

        // sum of the areas of the circles
        double sumOfCircles = shapes.stream()
                .filter(shape -> shape instanceof Circle)
                .mapToDouble(Shape::area)
                .sum();
        System.out.println("Sum of the areas of the circles: " + sumOfCircles);
        // average of the areas of the triangles
        double averageOfTriangles = shapes.stream()
                .filter(shape -> shape instanceof Triangle)
                .mapToDouble(Shape::area)
                .average()
                .orElse(0);

        // Summary of the shapes
        System.out.println("Summary of the shapes: ");
        DoubleSummaryStatistics areaStats = shapes.stream()
                .mapToDouble(Shape::area)
                .summaryStatistics();
        System.out.println("Number of shapes: " + areaStats.getCount());
        System.out.println("Total area: " + areaStats.getSum());
        System.out.println("Average area: " + areaStats.getAverage());
        System.out.println("Maximum area: " + areaStats.getMax());
        System.out.println("Minimum area: " + areaStats.getMin());

        // Average with reduce()
        // The reduce method here is used to accumulate the areas of all shapes into a single sum.
        // It takes two parameters: an initial value and a BinaryOperator. The initial value is 0.
        // The BinaryOperator takes two parameters: 'a' which is the accumulator that carries the
        // intermediate result, and 'b' which is the current area being processed. The operator
        // applies the function (a, b) -> a + b to accumulate the areas. So, it basically adds up
        // the areas of all the shapes. Then, this sum is divided by the number of shapes to get
        // the average area
        double average = shapes.stream()
                .mapToDouble(Shape::area)
                .reduce(0, (a, b) -> a + b) / shapes.size();
        System.out.println("Average area: " + average);
    }
}