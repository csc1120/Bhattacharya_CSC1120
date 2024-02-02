package Week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Week1.IrisFlower
 * 1. Read the iris.csv file stored in the data folder
 * 2. Read two columns  and store the values in an arraylist
 * 3. Perform element wise summation on the arraylist
 * 4. write the values or store the result as output.txt file
 */
public class IrisFlower {
    public static void main(String[] args) {
        System.out.println("enter the file name");
        Scanner stdIn = new Scanner(System.in);
        String fileName = stdIn.nextLine();
        Path path = Path.of("data/" + fileName + ".csv");
        // columnIndex start with index 0
        int columnIndex = 1;
        int columnIndex2 = 2;
        // methods used
        try {
            List<Double> columnData = readColumn(String.valueOf(path), columnIndex);
            List<Double> columnData2 = readColumn(String.valueOf(path), columnIndex2);
            List<Double> columnData3 = sumColumn(columnData, columnData2);
            writeColumn(columnData3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        // read the file using bufferReader
        private static List<Double> readColumn(String filepath, int columnIndex)  throws IOException{
        List<Double> columnData= new ArrayList<>();
        try(BufferedReader br= new BufferedReader( new FileReader(filepath))){
            String line;
            while ((line= br.readLine())!=null){
                String[] values= line.split(",");
                if(values.length>columnIndex){
                    try {
                        columnData.add(Double.parseDouble(values[columnIndex].trim()));
                    }
                    catch (NumberFormatException e){
                        System.out.println("Error parsing double from:" +values[columnIndex]);
                    }
                }
            }
        }
        return columnData;
        }
        // sum the two columns
        private static  List<Double> sumColumn(List<Double> columnData, List<Double> columnData2 ){
        List<Double>columnData3= new ArrayList<>();
        int data1_size= columnData.size();
        int data2_size= columnData2.size();
//        if(data1_size!=data2_size){
//            throw new IllegalArgumentException("Length should be same");
//        }
        if(data1_size>=data2_size){
            for (int i =0;i<data2_size; i++ ){
                columnData3.add(columnData.get(i)+ columnData2.get(i));
            }
        }
        if (data1_size<data2_size){
            for (int i=0; i<data1_size; i++){
                columnData3.add(columnData.get(i)+ columnData2.get(i));
            }
        }
        return  columnData3;
        }
// write the column3data to a txt file
        private static void writeColumn(List<Double>columnData) throws IOException{
            System.out.println("Writing data.....");
            Path imagePath= Path.of("data/outputA.txt");
            try{
            PrintWriter pw= new PrintWriter(imagePath.toFile());
                for(Double data:columnData){
                    pw.println(data);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                System.out.println("Done!");
            }
        }
    }


