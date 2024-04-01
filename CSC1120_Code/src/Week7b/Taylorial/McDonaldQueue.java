package Week7b.Taylorial;
// simulate a McDonald's queue
public class McDonaldQueue {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.offer("John");
        queue.offer("Jane");
        queue.offer("Joe");
        queue.offer("Jill");
        queue.offer("Jack");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
    // add service time to the queue and calculate the average service time
    // add a method to calculate the average service time
    // add a method to calculate the maximum service time

}
