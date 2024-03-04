package Week7b.Taylorial;

import Week7a.LinkedList;
import Week7b.SJLinkedList;

import java.util.List;

public class Stack_Driver {
    public static void main(String[] args) {
//we create a stack of integers using a LinkedList, SJLinkedList<>.
        PureStack<Integer> stack = new Stack<>(new SJLinkedList<>());
        SJStack<Integer> stack2 = new SJStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

        Queue<Integer> q = new Queue<>();
        q.offer(42);
        q.offer(-3);
        q.offer(17);       // front [42, -3, 17] back

        System.out.println(q.poll());

    }
}
