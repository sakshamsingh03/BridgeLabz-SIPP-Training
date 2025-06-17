import java.util.Scanner;

public class DigitAnalyzer {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initialize digit array and maxDigit size
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits
        while (number != 0) {
            int digit = number % 10;
            number = number / 10;

            // Resize array if needed
            if (index == maxDigit) {
                maxDigit *= 2;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < index; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }

            digits[index] = digit;
            index++;
        }

        // Find largest and second largest
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            int digit = digits[i];
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        // Display results
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        sc.close();
    }
}