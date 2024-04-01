package Week7b;

import java.util.Iterator;

public class SLLDriver {
    public static void main(String[] args) {
        SJLinkedList<Integer> list = new SJLinkedList<>();
        list.add(1);


        Iterator<Integer> iter = list.iterator();
        System.out.println(iter.hasNext());
        int num = iter.next();
        iter.remove();
        iter = list.iterator();

        System.out.println(iter.hasNext());
        System.out.println(num);


        for (Integer i : list) {
            // call the removeDivisibleByTwo method
            removeDivisibleByTwo(list);
            System.out.println(i);
        }
        // iterate through the list

    }
    // remove numbers from the list that are divisible by 2
    public static void removeDivisibleByTwo(SJLinkedList<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        System.out.println(iter.hasNext());
        int num = iter.next();
//        while (iter.hasNext()) {
//            int num = iter.next();
//            if (num % 2 == 0) {
                iter.remove();
            }
        }
