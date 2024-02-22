package Week6;
import Week6.TextBookLinkedList;
import Week5.TextBookArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BenchMark_sLL extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // method to add elements to the front of the linked list
    public static long addToFront_sLLBench(TextBookLinkedList<Integer> intArray, int size) {
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
//            intArray.add(i, (int) (Math.random() * size));
            intArray.addFirst((int) (Math.random() * size));
            // addFirst method from the TextBookLinkedList class
        }
        long end = System.nanoTime();
        return end - start;
    }

    // method to add an element in the Array list
    public static long addALBench(TextBookArrayList<Integer> intArray, int size) {
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            int element = (int) (Math.random() * size);
            intArray.addtoFront(element);
            // add method from the TextBookArrayList class

        }
        long end = System.nanoTime();
        return end - start;
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Create the X and Y axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        // Create the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Line Chart");

        // Call the TextBookArrayList class to create the arraylist

        int[] sizes = {1, 10, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 150000};
        XYChart.Series<Number, Number> linkedListSeries = new XYChart.Series<>();
        linkedListSeries.setName("Time taken to add elements to the Front of the linked list");

        XYChart.Series<Number, Number> arrayListSeries = new XYChart.Series<>();
        arrayListSeries.setName("Time taken to add elements to the Front of the Array list");

        for (int size : sizes) {
            TextBookLinkedList<Integer> linkedList = new TextBookLinkedList<>();
            long linkedListTime = addToFront_sLLBench(linkedList, size);
            linkedListSeries.getData().add(new XYChart.Data<>(size, linkedListTime));

            TextBookArrayList<Integer> arrayList = new TextBookArrayList<>();
            long arrayListTime = addALBench(arrayList, size);
            arrayListSeries.getData().add(new XYChart.Data<>(size, arrayListTime));
        }

        lineChart.getData().addAll(linkedListSeries, arrayListSeries);

        Scene scene  = new Scene(lineChart,800,600);
        stage.setScene(scene);
        stage.show();
    }
}