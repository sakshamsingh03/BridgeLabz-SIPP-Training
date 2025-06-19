import java.util.Scanner;
public class LowercaseComparison {
    public static String convertToLowerCase(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // If character is uppercase (ASCII 'A' to 'Z')
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32); // Convert to lowercase by adding 32
            }
            result.append(ch);
        }
        return result.toString();
    }
    // Method to compare two strings character-by-character
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();
        String lowerBuiltIn = input.toLowerCase();
        String lowerCustom = convertToLowerCase(input);
        boolean areEqual = compareStrings(lowerBuiltIn, lowerCustom);
        System.out.println("Lowercase using built-in method: " + lowerBuiltIn);
        System.out.println("Lowercase using custom method : " + lowerCustom);
        System.out.println("Are both results equal?        : " + areEqual);
    }
}