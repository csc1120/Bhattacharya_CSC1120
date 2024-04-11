package Week11;
import java.util.HashSet;
import java.util.Set;
public class Sets {
    public static void main(String[] args) {
        //// Create 2 sets and 1 array of strings.
        //HashSets are unordered and do not allow duplicates.
       Set<String> setB = new HashSet<>(Set.of("Bob", "Bill", "Ann", "Jill"));
       String[] listA = {"Ann", "Sally", "Jill", "Sally"};
       Set<String> setA = new HashSet<>();
       // Use for each to load set A from array listA
    for (String s : listA) {
       setA.add(s);
     }
      System.out.println("The 2 sets are: " + "\n" + setA
              + "\n" + setB);
      // Form the set union in setA and intersection in setAcopy.
      var setAcopy = new HashSet<>(setA); // Copy setA
      setA.addAll(setB);                    // SetA is union
      setAcopy.retainAll(setB);          // SetAcopy is intersection
        System.out.println("Items in set union are: " + setA);
       System.out.println("Items in intersection are: " + setAcopy);
//     // Form the set difference in setA and setB.
    var setAdiff = new HashSet<>(setA);
     setAdiff.removeAll(setB);
     System.out.println("Items in set difference are: " + setAdiff);
     //subset
        System.out.println("Is setA a subset of setB? " + setB.containsAll(setA));

   }
}

