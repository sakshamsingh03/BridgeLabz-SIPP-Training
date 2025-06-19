import java.util.Scanner;

public class ManualTrim {

    // Method to get string length without using .length()
    public static int getLength(String str) {
        char[] ch = str.toCharArray();
        int count = 0;
        for (char c : ch) {
            count++;
        }
        return count;
    }

    // 1. Method to find start and end indexes without leading/trailing spaces
    public static int[] findTrimIndexes(String str) {
        int start = 0;
        int end = getLength(str) - 1;

        // Find first non-space character
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Find last non-space character
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // 2. Method to create a substring using charAt()
    public static String manualSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // 3. Method to compare two strings using charAt()
    public static boolean compareStrings(String a, String b) {
        if (getLength(a) != getLength(b)) return false;
        for (int i = 0; i < getLength(a); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    // 4. Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input with leading/trailing spaces
        System.out.print("Enter a string with spaces: ");
        String input = scanner.nextLine();

        // Get trim indexes
        int[] trimIndexes = findTrimIndexes(input);
        int start = trimIndexes[0];
        int end = trimIndexes[1];

        // Get trimmed manually
        String manuallyTrimmed = manualSubstring(input, start, end);

        // Get trimmed using built-in (for comparison)
        String builtinTrimmed = input.trim();

        // Compare
        boolean same = compareStrings(manuallyTrimmed, builtinTrimmed);

        // Output
        System.out.println("\n--- Result ---");
        System.out.println("Original Input        : '" + input + "'");
        System.out.println("Manually Trimmed Text : '" + manuallyTrimmed + "'");
        System.out.println("Built-in Trimmed Text : '" + builtinTrimmed + "'");
        System.out.println("Are both equal?       : " + same);
    }
}