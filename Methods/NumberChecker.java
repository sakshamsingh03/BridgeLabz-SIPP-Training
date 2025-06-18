import java.util.Scanner;

public class NumberChecker {

    // 1. Count digits in the number
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    // 2. Store digits in an array
    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // 3. Check if it's a Duck Number (has zero, but not starting with zero)
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    // 4. Check if it's an Armstrong Number
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    // 5. Find largest and second largest
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    // 6. Find smallest and second smallest
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = countDigits(number);
        int[] digits = getDigitsArray(number);

        System.out.println("\nTotal Digits: " + digitCount);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Duck Number? " + (isDuckNumber(digits) ? "Yes" : "No"));
        System.out.println("Armstrong Number? " + (isArmstrongNumber(number, digits) ? "Yes" : "No"));

        int[] maxValues = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + maxValues[0]);
        System.out.println("Second Largest digit: " + (maxValues[1] == Integer.MIN_VALUE ? "Not Available" : maxValues[1]));

        int[] minValues = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + minValues[0]);
        System.out.println("Second Smallest digit: " + (minValues[1] == Integer.MAX_VALUE ? "Not Available" : minValues[1]));
    }
}
