import java.util.Scanner;

public class NumberChecker4 {

    // 1. Prime Number
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // 2. Neon Number
    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // 3. Spy Number
    public static boolean isSpy(int number) {
        int sum = 0, product = 1, temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // 4. Automorphic Number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // 5. Buzz Number
    public static boolean isBuzz(int number) {
        return (number % 7 == 0 || number % 10 == 7);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("\n--- Number Properties ---");
        System.out.println("Is Prime Number?        " + isPrime(number));
        System.out.println("Is Neon Number?         " + isNeon(number));
        System.out.println("Is Spy Number?          " + isSpy(number));
        System.out.println("Is Automorphic Number?  " + isAutomorphic(number));
        System.out.println("Is Buzz Number?         " + isBuzz(number));
    }
}
