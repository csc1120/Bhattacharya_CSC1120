package Week8;

public class CircularDriver {
    public static void main(String[] args) {
        CircularQueue<String> words = new CircularQueue<>();
words.offer("Wednesday");
words.offer("Wendy's");
words.poll();
        System.out.println(words);
words.offer("elephant");
    }
}
