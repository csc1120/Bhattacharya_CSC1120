package Week4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Using Streams to read and write files
 * 1. Find uniques words in a file
 * 2. Count the number of words in a file
 * 3. Count the number of lines in a file
 */
public class FileIOStream {
    public static void main(String[] args) throws IOException {
        // 1. Find uniques words in a file
        // 2. Count the number of words in a file
        // 3. Count the number of lines in a file
        String fileName = "src/TextFile.txt";
        File file = new File(fileName);
        long uniqueWords= Files.lines(file.toPath())
            .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .distinct()
            .count();

        // save the list of unique words to a file
        Files.lines(file.toPath())
            .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .distinct()
            .forEach(word -> System.out.println(word));


        System.out.println("Unique words: " + uniqueWords);
    }
}
