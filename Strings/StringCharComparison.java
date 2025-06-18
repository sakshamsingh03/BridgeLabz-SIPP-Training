import java.util.Scanner;

public class StringCharComparison {

    // Method to convert string to char array without using toCharArray()
    public static char[] customToCharArray(String input) {
        char[] chars = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            chars[i] = input.charAt(i);
        }
        return chars;
    }

    // Method to compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // Utility method to print a character array
    public static void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();

        char[] userDefinedArray = customToCharArray(input);
        char[] builtInArray = input.toCharArray();

        System.out.print("User-defined method result: ");
        printCharArray(userDefinedArray);

        System.out.print("Built-in toCharArray() result: ");
        printCharArray(builtInArray);

        boolean areEqual = compareCharArrays(userDefinedArray, builtInArray);
        System.out.println("Are both arrays equal? " + areEqual);

        scanner.close();
    }
}
