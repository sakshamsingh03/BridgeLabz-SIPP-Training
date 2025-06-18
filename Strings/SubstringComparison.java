import java.util.Scanner;

public class SubstringComparison {

    // Method to create a substring using charAt()
    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i); // appending character one by one
        }
        return result;
    }

    // Method to compare two strings character-by-character using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string and indices
        System.out.print("Enter the string: ");
        String input = scanner.next();

        System.out.print("Enter the start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter the end index: ");
        int end = scanner.nextInt();

        // Get substrings using both methods
        String customSub = customSubstring(input, start, end);
        String builtInSub = input.substring(start, end);

        // Display both substrings
        System.out.println("Custom substring using charAt(): " + customSub);
        System.out.println("Built-in substring(): " + builtInSub);

        // Compare and display result
        boolean isEqual = compareStrings(customSub, builtInSub);
        System.out.println("Are both substrings equal? " + isEqual);

        scanner.close();
    }
}
