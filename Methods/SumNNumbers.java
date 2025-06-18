import java.util.Scanner;

public class SumNNumbers {

    // Recursive method to find sum of first n natural numbers
    public static int sumRecursive(int n) {
        if (n == 1) return 1;
        return n + sumRecursive(n - 1);
    }

    // Method using formula: n(n + 1) / 2
    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number (n > 0): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Please enter a natural number greater than 0.");
            return;
        }

        int sumRec = sumRecursive(n);
        int sumForm = sumFormula(n);

        System.out.println("\nSum using recursion: " + sumRec);
        System.out.println("Sum using formula: " + sumForm);

        if (sumRec == sumForm) {
            System.out.println("✅ Both results match. Computation is correct.");
        } else {
            System.out.println("❌ Results do not match. There may be an error.");
        }
    }
}
