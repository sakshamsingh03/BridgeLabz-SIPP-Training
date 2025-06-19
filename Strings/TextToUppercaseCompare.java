import java.util.Scanner;
public class TextToUppercaseCompare {
    public static String convertToUpperCase(String input) {
        String result ="";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }
            result+=ch;
        }
        return result;
    }
    // Method to compare two strings character by character
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your text: ");
        String inputText = scanner.nextLine();
        String upperBuiltIn = inputText.toUpperCase();
        String upperCustom = convertToUpperCase(inputText);
        boolean areEqual = compareStrings(upperBuiltIn, upperCustom);
        System.out.println("Uppercase using built-in method: " + upperBuiltIn);
        System.out.println("Uppercase using custom method : " + upperCustom);
        System.out.println("Are both results equal?        : " + areEqual);
    }
}