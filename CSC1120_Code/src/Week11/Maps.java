package Week11;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Maps {
    public static void main(String[] args) {
        // Create a HashMap with keys and values.
        HashMap<String, String> aMap = new HashMap<>();
        aMap.put("J", "Jane");
        aMap.put("B", "Bill");
        aMap.put("S", "Sam");
        aMap.put("B1", "Bob");
        aMap.put("B2", "Bill");

        // Print the HashMap.
        System.out.println("The HashMap is: " + aMap);
        System.out.println("The value for key B1 is: " + aMap.get("B1"));
        System.out.println("The value for key Bill is: " + aMap.get("Bill"));
        //get the key for a value
        System.out.println("The key for value Bill is: " + getKey(aMap, "Bill"));
// put a new value for a key
        aMap.put("B", "Billy");
        System.out.println("The HashMap is: " + aMap);
        // Remove a key and value.
        aMap.remove("B");
        System.out.println("The HashMap is: " + aMap);
        // Print the keys.
        System.out.println("The keys are: " + aMap.keySet());
        // Print the values.
        System.out.println("The values are: " + aMap.values());
        // Print the entries.
        System.out.println("The entries are: " + aMap.entrySet());
        // Print the size.
        System.out.println("The size is: " + aMap.size());
        // Print the keys and values.
        for (Map.Entry<String, String> entry : aMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        // Print the keys and values using streams.
        aMap.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        // Print the keys and values using streams.
        Stream.of(aMap).forEach(System.out::println);

    }
    public static <K, V> K getKey(Map<? extends K, ? extends V> map, V value) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
