package Week6;

public class SLL_Demo {
    public static void main(String[] args) {
        // create a new linked list
        TextBookLinkedList<Integer> intSLL = new TextBookLinkedList<>();
        // add elements to the front of the linked list
        intSLL.addFirst(1);
        intSLL.addFirst(2);
        intSLL.addFirst(3) ;
        intSLL.addFirst(4);
        System.out.println(intSLL.toString());
        intSLL.add(0, 5);
        intSLL.add(1, 6);
        System.out.println(intSLL.toString());
        intSLL.remove(0);
        intSLL.remove(1);
        System.out.println(intSLL.toString());
        System.out.println(intSLL.size());
        intSLL.set(0, 7);
        System.out.println(intSLL.toString());

        //
// String
        TextBookLinkedList<String> stringSLL = new TextBookLinkedList<>();
        stringSLL.addFirst("Tom");
        stringSLL.addFirst("Jerry");
        stringSLL.addFirst("Spike");
        // get method
        for (int i = 0; i < stringSLL.size(); i++) {
            System.out.println(stringSLL.get(i));
        }
        // set method
        stringSLL.set(0, "Tyke");
        System.out.println(stringSLL.toString());;



    }
}
