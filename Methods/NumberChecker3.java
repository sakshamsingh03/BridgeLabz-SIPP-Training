import java.util.*;

public class NumberChecker3 {

    // 1. Method to count digits and return the digits array
    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static int getDigitCount(int number) {
        return String.valueOf(number).length();
    }

    // 2. Method to reverse a digits array
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // 3. Method to compare two arrays
    public static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    // 4. Method to check palindrome
    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseArray(digits);
        return arraysEqual(digits, reversed);
    }

    // 5. Method to check duck number
    public static boolean isDuckNumber(int number) {
        String str = String.valueOf(number);
        return str.indexOf('0') > 0; // 0 not at the first place
    }

    // Display array
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println("]");
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = getDigitCount(number);
        int[] digits = getDigitsArray(number);
        int[] reversedDigits = reverseArray(digits);

        System.out.println("\nDigit Count: " + digitCount);
        System.out.print("Digits: ");
        printArray(digits);
        System.out.print("Reversed Digits: ");
        printArray(reversedDigits);
        System.out.println("Are digits and reversed digits equal? " + arraysEqual(digits, reversedDigits));
        System.out.println("Is Palindrome? " + isPalindrome(number));
        System.out.println("Is Duck Number? " + isDuckNumber(number));
    }
}
