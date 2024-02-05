import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class demonstrates the usage of Java 8 streams for text data processing.
 */
public class LabwithStream {
    public static void main(String[] args) throws IOException {
        String fileName = "src/TextFile.txt";
        File file = new File(fileName);

        // Counting repeated words in a file
        // Files.lines      : Provides a Stream of String, one element per line from a file.
        // flatMap          : Maps each line to a Stream of words it consists of.
        // map              : Removes non-letter characters and converts words to lower case.
        // groupingBy       : Groups words by their identity, counting their occurrences.
        // filter           : Filters out entries with only one occurrence.
        // count            : Counts the number of remaining entries.
        long repeatedWords = Files.lines(file.toPath())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .count();
        System.out.printf("Repeated words: %d%n", repeatedWords);

        // Printing the list of repeated words, with each word stemmed and in lower case
        Files.lines(file.toPath())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println(e.getKey()));

        // Printing the counts of top 10 most frequent words
        // sorted : Sorts entries in reverse order by their counts.
        // limit  : Truncates the stream to the top 10 entries.
        Files.lines(file.toPath())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                // collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))   equivalent to Collectors.groupingBy(word -> word, Collectors.counting())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        // save the list of the entries to an array and number of occurrences to a file
        String[][] top10Words = Files.lines(file.toPath())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .map(e -> new String[]{e.getKey(), e.getValue().toString()})
                .toArray(String[][]::new);
        System.out.println(Arrays.toString(top10Words));
        // write the array to a file
        Files.write(new File("src/Top10Words.txt").toPath(), Arrays.stream(top10Words).map(e -> e[0] + ": " + e[1]).collect(Collectors.toList()));
    }
}