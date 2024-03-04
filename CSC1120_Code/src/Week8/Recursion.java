package Week8;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fibonacci(5));
        System.out.println(gcd(12, 8));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    // GCD of two numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    // other examples of recursion are the binary search and the palindrome
}
