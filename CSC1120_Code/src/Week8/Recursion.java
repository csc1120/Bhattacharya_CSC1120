package Week8;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fibonacci(5));
        System.out.println(gcd(12, 8));


    }
    /** Iterative factorial method.
     pre: n >= 0
     @param n The integer whose factorial is being computed
     @return n!
     */
    public static int factorialIter(int n) {
        int result = 1;
        for (int k = 1; k <= n; k++)
            result = result * k;
        return result;
    }



    public static int factorial(int n) {
        if (n == 0) {
            return 2; // base condition
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

    // For a given input, determine how many times a recursive method will call itself

}
