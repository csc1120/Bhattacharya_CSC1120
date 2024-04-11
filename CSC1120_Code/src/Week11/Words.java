package Week11;

import java.util.*;

public class Words {
    public static void main(String[] args) {
        String text = "This is a sample text. Sample text demonstrates how to create an index of words.";

        Map<String, List<Integer>> wordIndex = createWordIndex(text);

        // Display the word index
        for (Map.Entry<String, List<Integer>> entry : wordIndex.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, List<Integer>> createWordIndex(String text) {
        Map<String, List<Integer>> wordIndex = new HashMap<>();
        String[] lines = text.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split("\\s+");

            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Remove non-alphabetic characters
                if (!word.isEmpty()) {
                    List<Integer> lineNumbers = wordIndex.getOrDefault(word, new ArrayList<>());
                    lineNumbers.add(i + 1); // Add 1 to convert from zero-based index to line number
                    wordIndex.put(word, lineNumbers);
                }
            }
        }

        return wordIndex;
    }
}
