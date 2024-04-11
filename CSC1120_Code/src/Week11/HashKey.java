package Week11;

public class HashKey {

    public static void main(String[] args) {
        String input = "cat";
        int hashKey = calculateHashKey(input);
        System.out.println("Hash key for '" + input + "' is: " + hashKey);
    }

    public static int calculateHashKey(String input) {
        int hash = 0;
        for (int i = 0; i < input.length(); i++) {
            hash = 31 * hash + input.charAt(i);
        }
        return hash;
    }
}
