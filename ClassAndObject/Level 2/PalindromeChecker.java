import java.util.Scanner;
public class PalindromeChecker {
    private String text;
    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }
    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove spaces & punctuation
        int left = 0;
        int right = cleanText.length() - 1;

        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // Method to display result
    public void displayResult() {
        System.out.println("\nInput Text: " + text);
        if (isPalindrome()) {
            System.out.println("Result: It is a palindrome.");
        } else {
            System.out.println("Result: It is NOT a palindrome.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text to check for palindrome: ");
        String input = scanner.nextLine();
        PalindromeChecker checker = new PalindromeChecker(input);
        checker.displayResult();
    }
}