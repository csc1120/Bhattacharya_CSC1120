package Week5;
// saikath
import Week5.TextBookArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Benchmark2 extends Application{

    private static final int[] size = {10, 100, 200, 1000, 2000};
    private static final long[] averageTimes = new long[size.length];

    public static void main(String[] args) {
        int runs = 10;

        for (int i=0; i<size.length; i++){
            long[] time = new long[runs];
            for (int j=0; j<runs; j++){
                TextBookArrayList<Integer> intArray = new TextBookArrayList<>();
                time[j] = addToFrontBench(intArray, size[i]);
            }
            long average = 0;
            for (int k=0; k<runs; k++){
                average += time[k];
            }
            average = average / runs;
            averageTimes[i] = average;
            System.out.println("Average time taken to add elements to the front of the array: " + average);
        }

        for (int i=0; i<size.length; i++){
            long[] time = new long[runs];
            for (int j=0; j<runs; j++){
                TextBookArrayList<Integer> intArray = new TextBookArrayList<>();
                time[j] = addBench(intArray, size[i]);
            }
            long average = 0;
            for (int k=0; k<runs; k++){
                average += time[k];
            }
            average = average / runs;
            averageTimes[i] = average;
            System.out.println("Average time taken to add elements to the array: " + average);
        }

        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Array Size vs Time Chart");

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Array Size");
        yAxis.setLabel("Time (ns)");

        LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);

        XYChart.Series series = new XYChart.Series();
        series.setName("Array Size vs Time");

        for (int i = 0; i < size.length; i++) {
            series.getData().add(new XYChart.Data(size[i], averageTimes[i]));
        }

        Scene scene = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    private static long addToFrontBench(TextBookArrayList<Integer> intArray, int size) {
        long start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            intArray.addtoFront(j);
        }
        long end = System.nanoTime();
        return end - start;
    }

    // add method
    private static long addBench(TextBookArrayList<Integer> intArray, int max_size) {
        long start = System.nanoTime();
        for (int j = 0; j < max_size; j++) {
            int random = (int) (Math.random() * max_size);
            int randomPosition = (int) (Math.random() * (j+1));
            intArray.add(randomPosition, random);
        }
        long end = System.nanoTime();
        return end - start;
    }
}