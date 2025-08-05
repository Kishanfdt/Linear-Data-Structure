public class SumofDigits {
    public static int SumOfDigits(int n) {
        if (n == 0)
            return 0;
        else
            return n % 10 + SumOfDigits(n / 10);
    }
    public static void main(String[] args) {
        int number = 12;
        System.out.println("Sum of digits of " + number + " is: " + SumOfDigits(number));
    }
}
