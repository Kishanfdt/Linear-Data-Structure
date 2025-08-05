public class factorial {
    public static int factorial(int n) {
        if (n == 0) {
            System.out.println("factorial(0) = 1");
            return 1;
        } else {
            System.out.println(n + " * factorial(" + (n - 1) + ")");
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args) {
        int number = 15; // Example input
        System.out.println("Factorial of " + number + " is: " + factorial(number));
    }
}
