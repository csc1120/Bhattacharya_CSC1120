package Week5;

import Week5.TextBookArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * Main class for benchmarking performance of operations on TextBookArrayList.
 * This class extends Application to create a visual representation of the operation times.
 */
public class BenchMarkTextBookArray extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method to create a line chart that benchmarks performance with varying sizes of operations
     * on TextBookArrayList.
     * @param stage The primary window on which this Application will be shown.
     */
    @Override
    public void start(Stage stage) {
        // Time measurement and configuration variables omitted for brevity

        // Line chart creation and configuration omitted for brevity

        // Iterations and measurements over various sizes omitted for brevity

        // Scene and stage setup omitted for brevity
    }

    /**
     * Benchmarks performance of adding to the front of a TextBookArrayList.
     * @param intArray The array to perform operations on.
     * @param size The number of elements to add.
     * @return The nanoseconds it took to perform the operation.
     */
    public static long addToFrontBench(TextBookArrayList<Integer> intArray, int size) {
        // Time measurement and loop omitted for brevity
    }

    /**
     * Benchmarks performance of adding to a random index of a TextBookArrayList.
     * @param intArray The array to perform operations on.
     * @param size The number of elements to add.
     * @return The nanoseconds it took to perform the operation.
     */
    public static long addBench(TextBookArrayList<Integer> intArray, int size) {
        // Time measurement and loop omitted for brevity
    }

    /**
     * Benchmarks performance of checking for a value within a TextBookArrayList.
     * @param intArray The array to perform operations on.
     * @param size The number of checks to perform.
     * @return The nanoseconds it took to perform the operation.
     */
    public static long containsBench(TextBookArrayList<Integer> intArray, int size) {
        // Time measurement and loop omitted for brevity
    }
}