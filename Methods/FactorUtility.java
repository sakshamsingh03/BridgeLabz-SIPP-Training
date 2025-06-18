import java.util.Scanner;

public class FactorUtility {

    // 1. Find factors of a number and return an array
    public static int[] findFactors(int number) {
        int count = 0;
        // First loop to count number of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;

        // Second loop to store factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // 2. Find greatest factor from array
    public static int findGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int num : factors) {
            if (num > max) max = num;
        }
        return max;
    }

    // 3. Find sum of factors
    public static int findSum(int[] factors) {
        int sum = 0;
        for (int num : factors) {
            sum += num;
        }
        return sum;
    }

    // 4. Find product of factors
    public static long findProduct(int[] factors) {
        long product = 1;
        for (int num : factors) {
            product *= num;
        }
        return product;
    }

    // 5. Find product of cube of factors
    public static double findProductOfCubes(int[] factors) {
        double product = 1;
        for (int num : factors) {
            product *= Math.pow(num, 3);
        }
        return product;
    }

    // MAIN method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        System.out.println("\nGreatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + findSum(factors));
        System.out.println("Product of Factors: " + findProduct(factors));
        System.out.printf("Product of Cubes of Factors: %.2f\n", findProductOfCubes(factors));
    }
}
