package Week7b.Taylorial;
// check if a string is a palindrome using a stack and a queue

import Week7.LinkedList;
import Week7b.SJLinkedList;

public class Palindrome {
    public static void main(String[] args) {
        String test = "racecar";
        System.out.println(isPalindrome(test));
    }

    public static boolean isPalindrome(String s) {
        PureStack<Character> stack = new Stack<>(new SJLinkedList<>());
        PureStack<Character> stack2 = new Stack<>(new LinkedList<>());
        PureQueue<Character> queue = new Queue<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            queue.offer(s.charAt(i));
        }
        while (stack.size() > 0) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }
        return true;
    }
}
