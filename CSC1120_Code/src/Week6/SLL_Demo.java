package Week6;
import Week6.TextBookLinkedList;

public class SLL_Demo {
    public static void main(String[] args) {
        // create a new linked list
        TextBookLinkedList<Integer> intSLL = new TextBookLinkedList<>();
        // add elements to the front of the linked list
        intSLL.addFirst(1);
        intSLL.addFirst(2);
        intSLL.addFirst(3);
        intSLL.addFirst(4);
        System.out.println(intSLL.toString());
        intSLL.add(0, 5);
        intSLL.add(1, 6);
        intSLL.add(2, 7);
        // call the addNext method
        System.out.println(intSLL.toString());
        intSLL.remove(0);
        System.out.println(intSLL.toString());
        // var is a local variable
        //
// String
        TextBookLinkedList<String> stringSLL = new TextBookLinkedList<>();
        stringSLL.addFirst("Tom");
        stringSLL.addFirst("Jerry");
        stringSLL.addFirst("Spike");


    }
}
