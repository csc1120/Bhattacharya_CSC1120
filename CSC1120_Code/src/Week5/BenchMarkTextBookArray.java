package Week5;

import Week5.TextBookArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BenchMarkTextBookArray extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        long start = System.nanoTime();
        int[] size = { 100,  1000, 10000, 100000 };
        int runs = 2;

        // Create the X and Y axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Size of Array -n");
        yAxis.setLabel("Time (ns)- Big O(n)");

        // Create the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);


        XYChart.Series series = new XYChart.Series();
        series.setName("Time taken to add elements to the Front of the array");

        for (int i = 0; i < size.length; i++) {
            long[] time = new long[runs];
            for (int j = 0; j < runs; j++) {
                TextBookArrayList<Integer> intArray = new TextBookArrayList<>();
                time[j] = addToFrontBench(intArray, size[i]);
            }
            long average = 0;
            for (int k = 0; k < runs; k++) {
                average += time[k];
            }
            average = average / runs;
            series.getData().add(new XYChart.Data(size[i], average));
        }
// new series to contain the time taken to add elements at a random index to the arraylist
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Time taken to check if an element is in the array");
        for (int i = 0; i < size.length; i++) {
            long[] time = new long[runs];
            for (int j = 0; j < runs; j++) {
                TextBookArrayList<Integer> intArray = new TextBookArrayList<>();
                time[j] = containsBench(intArray, size[i]);
            }
            long average = 0;
            for (int k = 0; k < runs; k++) {
                average += time[k];
            }
            average = average / runs;
            series2.getData().add(new XYChart.Data(size[i], average));
        }

        // new series to add the time taken to add elements  random index to the arraylist
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Time taken to add elements at a random index to the array");
        for (int i = 0; i < size.length; i++) {
            long[] time = new long[runs];
            for (int j = 0; j < runs; j++) {
                TextBookArrayList<Integer> intArray = new TextBookArrayList<>();
               time[j] = addBench(intArray, size[i]);
            }
            long average = 0;
            for (int k = 0; k < runs; k++) {
                average += time[k];
            }
            average = average / runs;
            series3.getData().add(new XYChart.Data(size[i], average));
        }


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
      //  lineChart.getData().add(series2);
      // lineChart.getData().add(series3);

        // add legend to the chart

        stage.setScene(scene);
        stage.show();
        long end = System.nanoTime();
        System.out.println("Total time by the program " + (end - start)*1/1000000000 + " seconds");
        String title = "BenchMark Array- Program Execution Time "+ (end - start)*1/1000000000 + " seconds";
        lineChart.setTitle(title);

    }

    // method to add elements to front the arraylist
    public static long addToFrontBench(TextBookArrayList<Integer> intArray, int size) {

        long start1 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            // add a random arraylist of Integers to the arraylist
            int element = (int) (Math.random() * size);
            intArray.addtoFront(element);
        }
        long end1 = System.nanoTime();
        return (end1 - start1);
    }

    public static long addBench(TextBookArrayList<Integer> intArray, int size) {
        long start1 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            // add a random arraylist of Integers to the random index of the arraylist
               int element = (int) (Math.random() * 100);
                int index = (int) (Math.random() * (i+1));
                intArray.add(index, element);
    }
        long end1 = System.nanoTime();
        return (end1 - start1);
    }
    // method to benchmark contains method
    public static long containsBench(TextBookArrayList<Integer> intArray, int size) {
        // create a random arraylist of Integers
        for (int i = 0; i < size; i++) {
            int element = (int) (Math.random() * size);
            intArray.add(i, element);
        }
//        System.out.println(intArray.toString());
   intArray.shuffle();
  //      System.out.println(intArray.shuffle().toString());
        // shuffle the arraylist;
        int element = (int) (Math.random() *size);
       // System.out.println("Element to check if it is in the array: " + element);
        long start1 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            // add a random arraylist of Integers to the random index of the arraylist
            intArray.get(-1);
        }
        long end1 = System.nanoTime();
        return (end1 - start1)*1/1000000000;
    }
}