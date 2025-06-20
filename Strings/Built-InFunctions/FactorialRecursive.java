import java.util.Scanner;

public class FactorialRecursive {

    public static void main(String[] args) {
        int number = getInput("Enter a number: ");
        long result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }

    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
