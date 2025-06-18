import java.util.*;

public class NumberChecker5 {

    // 1. Count the number of digits
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    // 1. Store digits in an array
    public static int[] getDigits(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // 2. Sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    // 3. Sum of squares of digits
    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    // 4. Check if Harshad number
    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // 5. Frequency of each digit
    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        // Count non-zero frequencies to create 2D array
        int count = 0;
        for (int f : freq) {
            if (f > 0) count++;
        }

        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = getDigits(number);
        System.out.println("Count of digits: " + countDigits(number));

        System.out.println("Digits: " + Arrays.toString(digits));
        int sum = sumOfDigits(digits);
        System.out.println("Sum of digits: " + sum);

        double squareSum = sumOfSquares(digits);
        System.out.println("Sum of squares of digits: " + squareSum);

        boolean isHarshad = isHarshad(number, digits);
        System.out.println("Is Harshad number: " + (isHarshad ? "Yes" : "No"));

        int[][] freq = digitFrequency(digits);
        System.out.println("Digit Frequencies:");
        System.out.println("Digit | Frequency");
        for (int[] row : freq) {
            System.out.println("  " + row[0] + "    |    " + row[1]);
        }
    }
}
